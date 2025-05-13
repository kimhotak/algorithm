import sys
input = sys.stdin.readline
n, c = map(int, input().split())

# 집 좌표를 입력받아 정렬
# 최대 200_000개, 정렬은 O(N log N)으로 충분히 가능
X = [int(input()) for _ in range(n)]
X.sort()

left, right = 0, X[-1]-X[0]
answer = 0

while left <= right:
    mid = (right + left) // 2
    cnt = 1  # 설치한 공유기 수, 첫 집 항상 설치
    before = X[0]  # 이전 공유기 설치 위치 (첫 집부터 시작)

    for x in X:
        # 이전 공유기에서 mid 이상 떨어진 경우에만 설치
        if x - before >= mid:
            cnt += 1
            before = x

        # 공유기를 c개 이상 설치할 수 있으면 mid는 가능하므로 늘려보기
        if cnt >= c:
            answer = mid
            left = mid + 1
            break
    else:
        # 공유기를 c개 못 채웠으면 거리를 줄여야 함
        right = mid - 1

# 이분 탐색은 가능한 거리들 중 최대 값을 찾기 위한 것
# 가능한 거리를 늘려가다 실패하는 순간 종료되므로,
# 마지막으로 성공했던 mid 값을 기억해야 함
print(answer)