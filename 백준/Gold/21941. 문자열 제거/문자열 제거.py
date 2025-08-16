import sys
input = sys.stdin.readline

fs = input().strip()
# full string
m = int(input())

ss = [0]
# sub string
score = [0]

for _ in range(m):
    tmp = input().split()
    ss.append(tmp[0])
    score.append(int(tmp[1]))

dp = [0] * (len(fs) + 1)

for i in range(1, len(fs)+1):
    dp[i] = dp[i-1] + 1
    for j in range(1, m+1):
        if ss[j] == fs[i-len(ss[j]):i]:
            dp[i] = max(dp[i], dp[i-len(ss[j])] + score[j])
            
print(dp[-1])