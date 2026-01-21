import os
import sys
import urllib.request
import urllib.error
import json
import time
import subprocess
from datetime import datetime, timedelta, timezone

USER = os.environ.get("ATCODER_USER", "kimhotak")
API_URL = f"https://kenkoooo.com/atcoder/atcoder-api/v3/user/submissions?user={USER}&from_second=0"

HEADERS = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36'
}

def fetch_text(url):
    try:
        req = urllib.request.Request(url, headers=HEADERS)
        with urllib.request.urlopen(req) as res:
            return res.read().decode('utf-8')
    except urllib.error.HTTPError as e:
        print(f"❌ 접속 실패 ({e.code}): {url}")
        return None
    except Exception as e:
        print(f"❌ 오류: {e}")
        return None

def main():
    print(f"🚀 [{USER}] 제출 기록 동기화 시작...")
    
    data = fetch_text(API_URL)
    if not data:
        print("⚠️ API 데이터를 가져오지 못했습니다.")
        return

    ac_subs = [s for s in json.loads(data) if s['result'] == 'AC']
    ac_subs.sort(key=lambda x: x['epoch_second'])
    print(f"✨ 총 {len(ac_subs)}개의 정답 기록 발견")
    
    new_count = 0
    for sub in ac_subs:
        contest_id = sub['contest_id']
        problem_id = sub['problem_id']
        lang = sub['language']
        
        ext = ".txt"
        if "C++" in lang: ext = ".cpp"
        elif "Python" in lang or "PyPy" in lang: ext = ".py"
        elif "Java" in lang: ext = ".java"
        elif "Kotlin" in lang: ext = ".kt"
        elif "C#" in lang: ext = ".cs"
        elif "Go" in lang: ext = ".go"
        elif "Ruby" in lang: ext = ".rb"
        elif "Rust" in lang: ext = ".rs"
        
        save_dir = os.path.join("AtCoder", contest_id)
        file_path = os.path.join(save_dir, f"{problem_id}{ext}")

        if os.path.exists(file_path):
            continue

        print(f"📥 다운로드: {contest_id} - {problem_id}")
        
        code_url = f"https://atcoder.jp/contests/{contest_id}/submissions/{sub['id']}"
        html = fetch_text(code_url)
        
        if html:
            # HTML 파싱 (id="submission-code" 찾기)
            marker = 'id="submission-code"'
            idx = html.find(marker)
            
            if idx != -1:
                # 코드 영역 추출
                code_start = html.find('>', idx) + 1
                code_end = html.find('</pre>', code_start)
                raw_code = html[code_start:code_end]
                
                # HTML 특수문자 복원
                import html as html_lib
                final_code = html_lib.unescape(raw_code)

                os.makedirs(save_dir, exist_ok=True)
                with open(file_path, "w", encoding="utf-8") as f:
                    f.write(final_code)
                
                solve_time = datetime.fromtimestamp(sub['epoch_second'], timezone(timedelta(hours=9)))
                time_str = solve_time.strftime('%Y-%m-%d %H:%M:%S')
                
                env = os.environ.copy()
                env["GIT_AUTHOR_DATE"] = time_str
                env["GIT_COMMITTER_DATE"] = time_str
                
                subprocess.run(["git", "add", file_path], check=True)
                subprocess.run(["git", "commit", "-m", f"Add {contest_id} {problem_id}"], env=env, check=True)
                
                new_count += 1
                time.sleep(2.0)
            else:
                print("   ⚠️ 코드를 찾을 수 없습니다.")

    print(f"🎉 {new_count}개 새로운 풀이 저장" if new_count > 0 else "🎉 최신 상태")

if __name__ == "__main__":
    main()