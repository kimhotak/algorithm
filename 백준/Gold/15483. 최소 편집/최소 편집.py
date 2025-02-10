import sys
a = list(sys.stdin.readline().strip())
b = list(sys.stdin.readline().strip())
la, lb = len(a), len(b)

dp = [[None] * (la + 1) for _ in range(lb + 1)]

for i in range(lb + 1):
    if i == 0:
        dp[i] = [j for j in range(la + 1)]
        continue

    for j in range(la + 1):
        if j == 0:
            dp[i][j] = i
            continue

        if b[i-1] == a[j-1]:
            dp[i][j] = dp[i-1][j-1]
        else:
            dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])+1
print(dp[-1][-1])