import sys
input = sys.stdin.readline

N, M = map(int, input().split())
nums = [int(input()) for _ in range(N)]

# 누적합
prefix = [0] * (N + 1)
for i in range(N):
    prefix[i + 1] = prefix[i] + nums[i]

# dp[m][n]: n개까지 고려했을 때 m개의 구간을 만든 최대합
dp = [[-float('inf')] * (N + 1) for _ in range(M + 1)]
dp[0][0] = 0

for m in range(1, M + 1):  # m개 구간
    for n in range(m * 2 - 1, N + 1):  # n번째까지 고려
        for k in range(m * 2 - 1, n + 1):
            dp[m][n] = max(dp[m][n], dp[m - 1][k - 2] + prefix[n] - prefix[k - 1])

print(max(dp[M]))