import sys
input = sys.stdin.readline
n, k = map(int, input().split())
coin = [int(input()) for _ in range(n)]
coin.sort()

dp = [float('inf')] * (k + 1)
dp[0] = 0

for c in coin:
    for j in range(c, k+1):
        dp[j] = min(dp[j], 1 + dp[j-c])

print(dp[k] if dp[k] != float('inf') else -1)