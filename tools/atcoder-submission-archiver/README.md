# AtCoder Submission Archiver

AtCoder 제출을 주기적으로 아카이빙하는 스크립트입니다.

- 출력 폴더: `AtCoder/`

---

# AtCoder Submission Archiver (스펙)

> 상태: **최소 동작 버전 구현됨** (운영하며 보강)

---

## 1) 목표

- **완전 자동화**: 주기적으로 실행되어 AtCoder 제출 기록을 자동으로 동기화
- **타임머신 커밋**: 실행 시점이 아니라 **실제 제출 시각(분 단위)** 으로 커밋 시간을 맞춰 기여 기록을 최대한 보존
- **Fail-Safe 기록**: 정답(AC)이 없더라도 마지막 시도 코드를 저장
- **문서화**: 아카이빙된 문제 목록을 테이블로 자동 생성

---

## 2) 범위 / 비범위

### 범위
- AtCoder 제출 기록을 조회해 문제별로 1개의 대표 제출을 선정
- 선정된 제출의 소스코드를 파일로 저장
- 저장 직후 제출 시각으로 커밋 생성
- 요약 문서(테이블) 자동 생성

### 비범위(초기)
- 대회 중(또는 소스 접근 제한) 제출의 강제 복구
- 인터랙티브한 CLI/GUI 제공
- 다중 계정 지원

---

## 3) 실행 환경

- 실행 주체: **GitHub Actions** (주기 실행 + 수동 실행)
- 시간대: GitHub Actions cron은 **UTC** 기준
  - 예: 매주 일요일 00:30 KST 실행은 cron에서 UTC로 변환 필요

---

## 4) 데이터 소스 전략

AtCoder에는 “공식 단일 통합 API”가 제한적이므로, 다음 2단계를 전제로 합니다.

1. **제출 목록 조회**: 외부 데이터 소스(예: AtCoder Problems API) 또는 합법/안정적인 방식으로 제출 메타데이터 확보
2. **소스 코드 획득**: 제출 상세 페이지에서 소스 코드 확보

### 중요 제약
- 제출 소스는 상황에 따라 **로그인 필요/비공개/대회 중 제한**이 있을 수 있음
- 따라서 소스 접근이 불가하면 “실패”가 아니라 **스킵 + 로그 기록**(Fail-soft)을 기본으로 함

---

## 5) 그룹화 및 대표 제출 선정 규칙

제출들을 **문제(Problem ID)** 기준으로 그룹화하고, 각 그룹에서 1개 제출을 선택합니다.

- Case A: **AC 존재** → `AC` 중 **가장 최초의 AC(First Solve)** 선택
- Case B: **AC 없음** → 전체 제출 중 **가장 최근 제출(Last Try)** 선택

추가 규칙(권장)
- 동일 시각/동일 제출이 중복될 경우 `submission_id` 기준으로 안정적으로 정렬

---

## 6) 파일 저장 규칙

### 디렉토리 구조(권장)

- `AtCoder/<contest>/` 하위에 문제 파일을 저장

예)
- `AtCoder/abc389/a.cpp`
- `AtCoder/abc389/b.py`

### 파일명 규칙
- 기본: `<problem_id>.<ext>` (예: `abc440_a.java`)
- 저장 경로: `AtCoder/<contest>/<problem_id>.<ext>`

### 확장자 매핑
AtCoder 언어 문자열은 버전이 붙을 수 있으므로 prefix/정규식 기반 매핑을 사용합니다.

- `C++` → `.cpp`
- `Python` → `.py`
- `Java` → `.java`
- 그 외 → `.txt`

---

## 7) Git 커밋 규칙 (Time Travel)

- 파일 저장 후 문제 단위로 커밋 1개 생성
- 커밋 시간은 제출 시각을 사용
  - `GIT_AUTHOR_DATE`, `GIT_COMMITTER_DATE` 환경변수 사용
- 커밋 메시지(예시)
  - `AtCoder: abc389_a (AC, C++)`
  - `AtCoder: abc389_b (WA, Python)`

주의
- 기여 그래프(잔디)는 이메일/기본 브랜치/리포 공개 여부 등에 따라 표시가 달라질 수 있음

---

## 8) 문서(README) 자동 생성

대상 파일은 혼동을 막기 위해 **AtCoder 폴더 내부**로 고정합니다.

- 생성/갱신 파일: `AtCoder/README.md`
- 내용: 문제 목록 테이블

테이블 컬럼(예시)
- 문제 ID / 링크
- 문제 이름
- 결과(AC/WA…)
- 언어
- 제출 시각(UTC 또는 KST 표준화)

---

## 9) 증분 동기화(필수 권장)

매번 전체 제출을 재수집하면 호출량/시간이 커지므로, 마지막 동기화 지점을 저장합니다.

- 상태 파일(현재 구현): `tools/atcoder-submission-archiver/state.json`
  - `last_epoch_second`, `last_id`

동작
- 상태 파일이 있으면 그 이후 제출만 조회
- 실행 성공 시 상태 파일 갱신

---

## 10) 신뢰성/예외 처리 가이드

- 네트워크 오류/429/5xx는 재시도(백오프) 적용
- 소스 접근 불가(권한/비공개 등)는 스킵하고 로그로 남김
- 어떤 문제가 실패해도 전체 런이 깨지지 않도록 “부분 성공”을 허용

---

## 11) 향후 확장 아이디어

- 언어별 포매팅(black/clang-format) 옵션
- 문제 태그/난이도(가능하다면) 추가
- 로컬 실행용 CLI

## 로컬 실행

PowerShell 예시:

- Dry-run(다운로드/파일생성만, git 커밋 안 함)
  - `setx ATCODER_USER "<your_handle>"`
  - 새 터미널에서 `python tools/atcoder-submission-archiver/sync.py`
  - 또는 `DRY_RUN=1 python tools/atcoder-submission-archiver/sync.py`

## 소스코드 접근 제한

일부 제출은 소스가 비공개이거나 로그인 필요할 수 있습니다.

- 쿠키가 필요하면 GitHub Actions Secrets에 `ATCODER_REVEL_SESSION`(값만) 또는 `ATCODER_SESSION`(Cookie 헤더 전체)을 넣어서 동작시킬 수 있습니다.

## GitHub Actions

- 워크플로우: `.github/workflows/atcoder_submission_archiver.yml`
- 기본 스케줄: KST 일요일 00:30 (UTC 토요일 15:30)

> 잔디(Contribution)를 본인 계정으로 찍고 싶다면, 워크플로우에서 `git config user.email`을 본인 이메일로 바꿔야 합니다.
