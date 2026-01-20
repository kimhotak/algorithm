import os
import sys
import urllib.request
import urllib.error
import json
import time
import subprocess
from datetime import datetime, timedelta, timezone

# --------------------------
# [설정] 환경 변수에서 가져오기
# --------------------------
ATCODER_USERNAME = os.environ.get("ATCODER_USERNAME", "rlaghxkr") # 기본값
ATCODER_SESSION = os.environ.get("ATCODER_SESSION") # 시크릿

# 403 에러 방지를 위한 핵심 헤더 (브라우저 위장 + 쿠키)
HEADERS = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36',
    'Cookie': f'REVEL_SESSION={ATCODER_SESSION}' if ATCODER_SESSION else ''
}

API_URL = f"https://kenkoooo.com/atcoder/atcoder-api/v3/user/submissions?user={ATCODER_USERNAME}&from_second=0"

def fetch_text(url):
    """헤더를 포함하여 안전하게 URL 내용을 가져옵니다."""
    try:
        req = urllib.request.Request(url, headers=HEADERS)
        with urllib.request.urlopen(req) as res:
            return res.read().decode('utf-8')
    except urllib.error.HTTPError as e:
        print(f"❌ 접속 실패 ({e.code}): {url}")
        return None
    except Exception as e:
        print(f"❌ 오류 발생: {e}")
        return None

def main():
    print(f"🚀 [{ATCODER_USERNAME}] 님의 제출 기록 동기화 시작...")
    
    # 1. 시크릿 확인
    if not ATCODER_SESSION:
        print("⚠️ 경고: 'ATCODER_SESSION' 시크릿이 없습니다. 비공개 코드는 못 가져옵니다.")

    # 2. API로 제출 목록 조회
    data = fetch_text(API_URL)
    if not data:
        return

    submissions = json.loads(data)
    # AC(정답)만 필터링 후, 오래된 순서대로 정렬
    ac_subs = [s for s in submissions if s['result'] == 'AC']
    ac_subs.sort(key=lambda x: x['epoch_second'])

    print(f"✨ 총 {len(ac_subs)}개의 정답 기록을 발견했습니다.")
    
    new_count = 0
    for sub in ac_subs:
        contest_id = sub['contest_id']
        problem_id = sub['problem_id']
        lang = sub['language']
        
        # 확장자 결정
        ext = ".txt"
        if "C++" in lang: ext = ".cpp"
        elif "Python" in lang or "PyPy" in lang: ext = ".py"
        elif "Java" in lang: ext = ".java"
        elif "Kotlin" in lang: ext = ".kt"
        elif "C#" in lang: ext = ".cs"
        
        # 저장 경로: AtCoder/대회명/문제명.확장자
        save_dir = os.path.join("AtCoder", contest_id)
        file_path = os.path.join(save_dir, f"{problem_id}{ext}")

        # 이미 파일이 존재하면 건너뜀 (중복 방지)
        if os.path.exists(file_path):
            continue

        print(f"📥 다운로드 중: {contest_id} - {problem_id}")
        
        # 3. 소스코드 상세 페이지 접속 (쿠키 사용)
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
                
                # HTML 특수문자(&lt; 등) 복원
                import html as html_lib
                final_code = html_lib.unescape(raw_code)

                # 파일 저장
                os.makedirs(save_dir, exist_ok=True)
                with open(file_path, "w", encoding="utf-8") as f:
                    f.write(final_code)
                
                # 4. 타임머신 커밋 (푼 날짜로 기록)
                solve_time = datetime.fromtimestamp(sub['epoch_second'], timezone(timedelta(hours=9)))
                time_str = solve_time.strftime('%Y-%m-%d %H:%M:%S')
                
                env = os.environ.copy()
                env["GIT_AUTHOR_DATE"] = time_str
                env["GIT_COMMITTER_DATE"] = time_str
                
                subprocess.run(["git", "add", file_path], check=True)
                subprocess.run(["git", "commit", "-m", f"Add {contest_id} {problem_id}"], env=env, check=True)
                
                new_count += 1
                time.sleep(1.5) # 서버 부하 방지 (중요!)
            else:
                print("   ⚠️ 코드를 찾을 수 없습니다. (비공개 상태)")

    if new_count > 0:
        print(f"🎉 {new_count}개의 새로운 풀이를 저장했습니다!")
    else:
        print("🎉 최신 상태입니다. (새로운 풀이 없음)")

if __name__ == "__main__":
    main()