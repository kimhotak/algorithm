# algorithm

[![AtCoder Archiver](https://github.com/kimhotak/algorithm/actions/workflows/atcoder_submission_archiver.yml/badge.svg)](https://github.com/kimhotak/algorithm/actions/workflows/atcoder_submission_archiver.yml)

BaekjoonHub와 GitHub Actions를 활용해 **백준 / AtCoder 풀이를 자동 수집 및 아카이빙하는 알고리즘 저장소**입니다.

---

# Automation Highlights

### Baekjoon
- **BaekjoonHub** 브라우저 확장을 사용
- 제출한 풀이가 GitHub에 **자동 업로드**

### AtCoder
- **GitHub Actions**가 매일 실행
- AtCoder 제출 목록을 조회
- **AC (정답) 제출만 선별**
- 제출 코드 자동 수집
- `AtCoder/<contest>/` 구조로 저장
- **제출 시각 기준으로 커밋 생성**

### Multi-language workspace
로컬에서 여러 언어로 풀이를 작성할 수 있도록 작업 공간을 분리

- C++
- Python
- Java

---

# How it Works

## Baekjoon

1. BaekjoonHub 브라우저 확장을 통해 제출
2. 제출 성공 시 GitHub 저장소에 자동 업로드
3. 난이도별 폴더에 저장

예시
