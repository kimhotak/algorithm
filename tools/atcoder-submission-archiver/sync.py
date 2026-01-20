import json
import os
import re
import subprocess
import sys
import time
import urllib.error
import urllib.parse
import urllib.request
from dataclasses import dataclass
from datetime import datetime, timedelta, timezone
from html.parser import HTMLParser
from pathlib import Path
from typing import Any, Dict, Iterable, List, Optional, Tuple


KST = timezone(timedelta(hours=9))

REPO_ROOT = Path(__file__).resolve().parents[2]
TOOL_DIR = REPO_ROOT / "tools" / "atcoder-submission-archiver"
STATE_PATH = TOOL_DIR / "state.json"
INDEX_PATH = TOOL_DIR / "index.json"
OUTPUT_ROOT = REPO_ROOT / "AtCoder"
OUTPUT_README = OUTPUT_ROOT / "README.md"

ATCODER_SUBMISSIONS_API = (
    "https://kenkoooo.com/atcoder/atcoder-api/v3/user/submissions"
)


@dataclass(frozen=True)
class Submission:
    id: int
    epoch_second: int
    problem_id: str
    contest_id: str
    language: str
    result: str

    @property
    def sort_key(self) -> Tuple[int, int]:
        return (self.epoch_second, self.id)


class SubmissionCodeParser(HTMLParser):
    def __init__(self) -> None:
        super().__init__(convert_charrefs=True)
        self._in_target_pre = False
        self._code_parts: List[str] = []

    def handle_starttag(self, tag: str, attrs: List[Tuple[str, Optional[str]]]) -> None:
        if tag != "pre":
            return
        attrs_dict = dict(attrs)
        if attrs_dict.get("id") == "submission-code":
            self._in_target_pre = True

    def handle_endtag(self, tag: str) -> None:
        if tag == "pre" and self._in_target_pre:
            self._in_target_pre = False

    def handle_data(self, data: str) -> None:
        if self._in_target_pre:
            self._code_parts.append(data)

    def get_code(self) -> str:
        return "".join(self._code_parts)


def log(message: str) -> None:
    print(message, flush=True)


def load_json(path: Path, default: Any) -> Any:
    if not path.exists():
        return default
    return json.loads(path.read_text(encoding="utf-8"))


def save_json(path: Path, data: Any) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(json.dumps(data, ensure_ascii=False, indent=2) + "\n", encoding="utf-8")


def http_get(url: str, *, headers: Optional[Dict[str, str]] = None, timeout: int = 30) -> bytes:
    req = urllib.request.Request(url, headers=headers or {})
    with urllib.request.urlopen(req, timeout=timeout) as resp:
        return resp.read()


def http_get_with_retry(
    url: str,
    *,
    headers: Optional[Dict[str, str]] = None,
    timeout: int = 30,
    retries: int = 5,
    base_sleep: float = 1.0,
) -> bytes:
    last_exc: Optional[Exception] = None
    for attempt in range(1, retries + 1):
        try:
            return http_get(url, headers=headers, timeout=timeout)
        except urllib.error.HTTPError as exc:
            last_exc = exc
            status = getattr(exc, "code", None)
            if status in (429, 500, 502, 503, 504):
                sleep_s = base_sleep * (2 ** (attempt - 1))
                log(f"HTTP {status} 재시도 {attempt}/{retries}: {url} (sleep {sleep_s:.1f}s)")
                time.sleep(sleep_s)
                continue
            raise
        except Exception as exc:
            last_exc = exc
            sleep_s = base_sleep * (2 ** (attempt - 1))
            log(f"요청 실패 재시도 {attempt}/{retries}: {url} (sleep {sleep_s:.1f}s)")
            time.sleep(sleep_s)
            continue
    assert last_exc is not None
    raise last_exc


def parse_submissions(raw: List[Dict[str, Any]]) -> List[Submission]:
    submissions: List[Submission] = []
    for item in raw:
        try:
            submissions.append(
                Submission(
                    id=int(item["id"]),
                    epoch_second=int(item["epoch_second"]),
                    problem_id=str(item["problem_id"]),
                    contest_id=str(item["contest_id"]),
                    language=str(item.get("language") or ""),
                    result=str(item.get("result") or ""),
                )
            )
        except Exception:
            continue
    submissions.sort(key=lambda s: s.sort_key)
    return submissions


def fetch_new_submissions(
    user: str,
    *,
    last_epoch_second: int,
    last_id: int,
) -> List[Submission]:
    params = f"?user={urllib.parse.quote(user)}&from_second={int(last_epoch_second)}"
    url = ATCODER_SUBMISSIONS_API + params
    log(f"제출 목록 조회: {url}")
    raw_bytes = http_get_with_retry(url)
    raw_json = json.loads(raw_bytes.decode("utf-8"))
    submissions = parse_submissions(raw_json)

    def is_new(s: Submission) -> bool:
        if s.epoch_second > last_epoch_second:
            return True
        if s.epoch_second == last_epoch_second and s.id > last_id:
            return True
        return False

    new_items = [s for s in submissions if is_new(s)]
    return new_items


def normalize_extension(language: str) -> str:
    lang = language.strip()
    if lang.startswith("C++"):
        return ".cpp"
    if lang.startswith("Python"):
        return ".py"
    if lang.startswith("Java"):
        return ".java"
    return ".txt"


def task_slug(problem_id: str, contest_id: str) -> str:
    prefix = contest_id + "_"
    if problem_id.startswith(prefix):
        return problem_id[len(prefix) :]
    if "_" in problem_id:
        return problem_id.split("_", 1)[1]
    return problem_id


def submission_url(contest_id: str, submission_id: int) -> str:
    return f"https://atcoder.jp/contests/{contest_id}/submissions/{submission_id}"


def extract_submission_code(html: str) -> str:
    parser = SubmissionCodeParser()
    parser.feed(html)
    code = parser.get_code()
    return code


def download_code(submission: Submission, *, cookie: Optional[str]) -> Optional[str]:
    url = submission_url(submission.contest_id, submission.id)
    headers: Dict[str, str] = {
        "User-Agent": "atcoder-submission-archiver/0.1",
    }
    if cookie:
        headers["Cookie"] = cookie

    try:
        html_bytes = http_get_with_retry(url, headers=headers)
    except urllib.error.HTTPError as exc:
        log(f"제출 페이지 접근 실패(HTTP {exc.code}): {url}")
        return None

    html = html_bytes.decode("utf-8", errors="replace")
    code = extract_submission_code(html)

    code = code.replace("\r\n", "\n").replace("\r", "\n")
    if not code.strip():
        log(f"소스코드 추출 실패(비공개/로그인 필요 가능): {url}")
        return None

    if not code.endswith("\n"):
        code += "\n"
    return code


def kst_string(epoch_second: int) -> str:
    return datetime.fromtimestamp(epoch_second, tz=KST).strftime("%Y-%m-%d %H:%M")


def ensure_parent(path: Path) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)


def run_git(args: List[str], *, env: Optional[Dict[str, str]] = None) -> subprocess.CompletedProcess:
    return subprocess.run(
        ["git", *args],
        cwd=str(REPO_ROOT),
        env={**os.environ, **(env or {})},
        text=True,
        capture_output=True,
    )


def has_staged_changes() -> bool:
    proc = run_git(["diff", "--cached", "--quiet"])
    return proc.returncode != 0


def stage_files(paths: Iterable[Path]) -> None:
    rels = [str(p.relative_to(REPO_ROOT)).replace("\\", "/") for p in paths]
    if not rels:
        return
    proc = run_git(["add", "--", *rels])
    if proc.returncode != 0:
        raise RuntimeError(proc.stderr.strip() or proc.stdout.strip())


def commit_with_date(message: str, *, epoch_second: int) -> None:
    # Git expects RFC 2822-ish / ISO-ish strings; ISO works.
    dt = datetime.fromtimestamp(epoch_second, tz=timezone.utc)
    date_str = dt.strftime("%Y-%m-%dT%H:%M:%SZ")
    env = {
        "GIT_AUTHOR_DATE": date_str,
        "GIT_COMMITTER_DATE": date_str,
    }
    proc = run_git(["commit", "-m", message], env=env)
    if proc.returncode != 0:
        out = (proc.stderr.strip() or proc.stdout.strip())
        raise RuntimeError(out)


def safe_link(problem_id: str) -> str:
    # problem_id is like abc389_a
    if "_" in problem_id:
        contest, task = problem_id.split("_", 1)
        return f"https://atcoder.jp/contests/{contest}/tasks/{contest}_{task}"
    return f"https://atcoder.jp/contests/{problem_id}/tasks/{problem_id}"


def update_readme(index: Dict[str, Any]) -> None:
    ensure_parent(OUTPUT_README)

    items = list(index.values())
    items.sort(key=lambda x: (int(x.get("epoch_second", 0)), int(x.get("submission_id", 0))), reverse=True)

    lines: List[str] = []
    lines.append("# AtCoder Ghost Archive\n")
    lines.append("이 폴더는 자동 생성/갱신됩니다.\n")
    lines.append("\n")
    lines.append("| Problem | Result | Lang | Submitted(KST) | File |\n")
    lines.append("| :-- | :--: | :-- | :-- | :-- |\n")

    for it in items:
        problem_id = it.get("problem_id", "")
        url = safe_link(problem_id)
        result = it.get("result", "")
        lang = it.get("language", "")
        epoch = int(it.get("epoch_second", 0))
        submitted = kst_string(epoch) if epoch else ""
        rel_path = it.get("path", "")
        file_cell = f"`{rel_path}`" if rel_path else ""
        lines.append(
            f"| [{problem_id}]({url}) | {result} | {lang} | {submitted} | {file_cell} |\n"
        )

    OUTPUT_README.write_text("".join(lines), encoding="utf-8")


def main() -> int:
    user = os.environ.get("ATCODER_USER", "").strip()
    if not user:
        log("환경변수 ATCODER_USER 가 필요합니다.")
        return 2

    dry_run = os.environ.get("DRY_RUN", "").strip() == "1"

    # Cookie: provide either ATCODER_REVEL_SESSION or ATCODER_SESSION
    revel = os.environ.get("ATCODER_REVEL_SESSION", "").strip()
    session = os.environ.get("ATCODER_SESSION", "").strip()
    cookie = None
    if revel:
        cookie = f"REVEL_SESSION={revel}"
    elif session:
        cookie = session  # user can pass full Cookie header value

    state = load_json(STATE_PATH, {"last_epoch_second": 0, "last_id": 0})
    last_epoch_second = int(state.get("last_epoch_second", 0))
    last_id = int(state.get("last_id", 0))

    index: Dict[str, Any] = load_json(INDEX_PATH, {})

    new_submissions = fetch_new_submissions(user, last_epoch_second=last_epoch_second, last_id=last_id)
    if not new_submissions:
        log("신규 제출이 없습니다.")
        update_readme(index)
        if not dry_run:
            stage_files([OUTPUT_README])
            if has_staged_changes():
                commit_with_date("AtCoder ghost: update README", epoch_second=int(time.time()))
        return 0

    # Update state to max seen in new submissions (safe even if we fail later; but we commit state only at end)
    max_s = max(new_submissions, key=lambda s: s.sort_key)

    by_problem: Dict[str, List[Submission]] = {}
    for s in new_submissions:
        by_problem.setdefault(s.problem_id, []).append(s)

    selected: List[Submission] = []
    for problem_id, subs in by_problem.items():
        subs.sort(key=lambda s: s.sort_key)

        stored = index.get(problem_id)
        if stored and stored.get("result") == "AC":
            # first AC is already archived; ignore future submissions.
            continue

        ac_subs = [s for s in subs if s.result == "AC"]
        if ac_subs:
            best = min(ac_subs, key=lambda s: s.sort_key)
        else:
            best = max(subs, key=lambda s: s.sort_key)

        if stored and stored.get("result") != "AC":
            stored_epoch = int(stored.get("epoch_second", 0))
            stored_id = int(stored.get("submission_id", 0))
            if best.result != "AC":
                if (best.epoch_second, best.id) <= (stored_epoch, stored_id):
                    continue

        selected.append(best)

    if not selected:
        log("대표 제출로 갱신할 대상이 없습니다.")
        state["last_epoch_second"] = max_s.epoch_second
        state["last_id"] = max_s.id
        save_json(STATE_PATH, state)
        update_readme(index)
        if not dry_run:
            stage_files([STATE_PATH, OUTPUT_README, INDEX_PATH])
            if has_staged_changes():
                commit_with_date("AtCoder ghost: update state", epoch_second=int(time.time()))
        return 0

    selected.sort(key=lambda s: s.sort_key)

    written_files: List[Path] = []

    for s in selected:
        ext = normalize_extension(s.language)
        # 기존 AtCoder 풀이 파일 규칙(예: abc440_a.java)과 맞추기 위해 problem_id 기반으로 저장합니다.
        # problem_id는 일반적으로 `<contest>_<task>` 형태입니다.
        out_path = OUTPUT_ROOT / s.contest_id / f"{s.problem_id}{ext}"
        ensure_parent(out_path)

        log(f"다운로드: {s.problem_id} {s.result} {s.language} @ {kst_string(s.epoch_second)}")
        code = download_code(s, cookie=cookie)
        if code is None:
            continue

        # If file exists and identical, skip.
        if out_path.exists():
            existing = out_path.read_text(encoding="utf-8", errors="replace")
            if existing == code:
                log(f"변경 없음: {out_path}")
            else:
                out_path.write_text(code, encoding="utf-8")
                written_files.append(out_path)
        else:
            out_path.write_text(code, encoding="utf-8")
            written_files.append(out_path)

        # Update index (even if file unchanged, metadata may change when transitioning to AC)
        rel = out_path.relative_to(REPO_ROOT).as_posix()
        index[s.problem_id] = {
            "problem_id": s.problem_id,
            "contest_id": s.contest_id,
            "submission_id": s.id,
            "epoch_second": s.epoch_second,
            "result": s.result,
            "language": s.language,
            "path": rel,
        }

        if dry_run:
            continue

        # Commit per problem (time travel)
        stage_files([out_path])
        if has_staged_changes():
            msg = f"AtCoder ghost: {s.problem_id} ({s.result}, {s.language})"
            commit_with_date(msg, epoch_second=s.epoch_second)

    # Persist state + index + README once.
    state["last_epoch_second"] = max_s.epoch_second
    state["last_id"] = max_s.id
    save_json(STATE_PATH, state)
    save_json(INDEX_PATH, index)
    update_readme(index)

    if not dry_run:
        stage_files([STATE_PATH, INDEX_PATH, OUTPUT_README])
        if has_staged_changes():
            commit_with_date("AtCoder ghost: update index/state", epoch_second=int(time.time()))

    log("완료")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
