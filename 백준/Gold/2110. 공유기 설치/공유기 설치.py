import sys
input = sys.stdin.readline

n, c = map(int, input().split())
X = sorted(int(input()) for _ in range(n))

left, right = 1, X[-1] - X[0]
answer = 0

while left <= right:
    mid = (left + right) // 2
    cnt = 1
    prev = X[0]

    for i in range(1, n):
        if X[i] - prev >= mid:
            cnt += 1
            prev = X[i]

    if cnt >= c:
        answer = mid
        left = mid + 1
    else:
        right = mid - 1

print(answer)
