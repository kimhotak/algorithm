import sys
input = sys.stdin.readline
t = int(input())
dp = [0] * 12
dp[0] = 1
comb = (1,2,3)
for i in range(1, 12):
    for c in comb:
        if i-c < 0:
            break
        dp[i] += dp[i-c]

for _ in range(t):
    print(dp[int(input())])