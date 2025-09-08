import sys
input = sys.stdin.readline
n, k = map(int, input().split())
item = list(tuple(map(int, input().split())) for _ in range(n))

dp = [[0]*(n+1) for _ in range(k+1)]

for i in range(1,n+1):
    weight, value = item[i-1]
    for w in range(1,k+1):
        if weight > w:
            dp[w][i] = dp[w][i-1]
        else: # weight >= w:
            dp[w][i] = max(dp[w][i-1], dp[w-weight][i-1] + value)

print(dp[k][n])