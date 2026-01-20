import os
import sys
import urllib.request
import urllib.error
import json
import time
import subprocess
from datetime import datetime, timedelta, timezone

# -----------------------------------------------------------------------------
# [설정] 환경 변수 로드
# -----------------------------------------------------------------------------
ATCODER_USERNAME = os.environ.get("ATCODER_USERNAME", "kimhotak") 
ATCODER_SESSION = os.environ.get("ATCODER_SESSION") 

# -----------------------------------------------------------------------------
# [헤더 분리 전략] 403 에러 방지
# -----------------------------------------------------------------------------
# 1. API용 헤더 (쿠키 없음 -> kenkoooo.com 접속용)
HEADERS_API = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36'
}

# 2. 엣코더용 헤더 (쿠키 포함 -> atcoder.jp 소스코드 크롤링용)
HEADERS_ATCODER = HEADERS_API.copy()
if ATCODER_SESSION:
    HEADERS_ATCODER['Cookie'] = f'REVEL_SESSION={ATCODER_SESSION}'

API_URL = f"https://kenkoooo.com/atcoder/atcoder-api/v3/user/submissions?user={ATCODER_USERNAME}&from_second=0"

def fetch_text(url, headers):
    """지정된 헤더를 사용하여 URL 내용을 가져옵니다."""
    try:
        req = urllib.request.Request(url, headers=headers)
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
    
    # 1. API로 제출 목록 가져오기 (API용 깨끗한 헤더 사용)
    data = fetch_text(API_URL, HEADERS_API)
    if not data:
        print("⚠️ API 데이터를 가져오지 못했습니다. 잠시 후 다시 시도하세요.")
        return

    submissions = json.loads(data)
    # AC(정답)만 필터링
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
        elif "Go" in lang: ext = ".go"
        elif "Ruby" in lang: ext = ".rb"
        elif "Rust" in lang: ext = ".rs"
        
        # 저장 경로: AtCoder/대회명/문제명.확장자
        save_dir = os.path.join("AtCoder", contest_id)
        file_path = os.path.join(save_dir, f"{problem_id}{ext}")

        # 이미 파일이 존재하면 건너뜀
        if os.path.exists(file_path):
            continue

        print(f"📥 다운로드 중: {contest_id} - {problem_id}")
        
        # 3. 소스코드 상세 페이지 접속 (여기는 쿠키 필수!)
        code_url = f"https://atcoder.jp/contests/{contest_id}/submissions/{sub['id']}"
        html = fetch_text(code_url, HEADERS_ATCODER)
        
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

                # 파일 저장
                os.makedirs(save_dir, exist_ok=True)
                with open(file_path, "w", encoding="utf-8") as f:
                    f.write(final_code)
                
                # Git 커밋 (타임머신)
                solve_time = datetime.fromtimestamp(sub['epoch_second'], timezone(timedelta(hours=9)))
                time_str = solve_time.strftime('%Y-%m-%d %H:%M:%S')
                
                env = os.environ.copy()
                env["GIT_AUTHOR_DATE"] = time_str
                env["GIT_COMMITTER_DATE"] = time_str
                
                subprocess.run(["git", "add", file_path], check=True)
                subprocess.run(["git", "commit", "-m", f"Add {contest_id} {problem_id}"], env=env, check=True)
                
                new_count += 1
                time.sleep(2.0) # 서버 부하 방지 (2초 대기)
            else:
                print("   ⚠️ 코드를 찾을 수 없습니다. (비공개 상태거나 파싱 실패)")
                # 403이 아니지만 코드가 안 보이면 세션 만료 가능성 있음
                if "Sign In" in html:
                    print("   🚨 로그인 세션이 만료된 것 같습니다. 쿠키를 갱신해주세요.")

    if new_count > 0:
        print(f"🎉 {new_count}개의 새로운 풀이를 저장했습니다!")
    else:
        print("🎉 최신 상태입니다. (새로운 풀이 없음)")

if __name__ == "__main__":
    main()