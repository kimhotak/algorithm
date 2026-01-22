# AtCoder Submission Archiver

설계는 Gemini로 하고 코딩은 GitHub Copilot을 활용했습니다.

AtCoder 제출을 주기적으로 아카이빙하는 스크립트입니다.

출력 폴더: `AtCoder/`

동작 요약:
- kenkoooo API에서 제출 목록을 조회하고 AC만 저장
- 제출 상세 페이지에서 소스 코드를 가져와 저장
- 저장 직후 제출 시각으로 커밋 생성

로컬 실행:
- `setx ATCODER_USER "<your_handle>"`
- 새 터미널에서 `python tools/atcoder-submission-archiver/sync.py`

GitHub Actions:
- 워크플로우: `.github/workflows/atcoder_submission_archiver.yml`
- 스케줄: 매일 KST 00:30 (UTC 15:30)

필수 설정:
- GitHub Variables에 `ATCODER_USER` (AtCoder 핸들)

주의:
- kenkoooo API가 403을 반환할 수 있어 브라우저형 헤더를 사용합니다.
- 일부 제출은 접근 제한으로 소스가 비어 있을 수 있습니다.
