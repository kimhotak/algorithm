import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = [int(input()) for _ in range(N)]

dp = [[-float('inf')] * (M + 1) for _ in range(N + 1)]
dp[0][0] = 0

for i in range(1, N + 1):
    for j in range(M + 1):
        # 이전 값을 이어받음 (선택 안함)
        dp[i][j] = max(dp[i][j], dp[i-1][j])

    for j in range(1, M + 1):
        temp_sum = 0
        for k in range(i, 0, -1):
            temp_sum += arr[k-1]
            if k >= 2:
                dp[i][j] = max(dp[i][j], dp[k-2][j-1] + temp_sum)
            elif j == 1:
                dp[i][j] = max(dp[i][j], temp_sum)

print(dp[N][M])
