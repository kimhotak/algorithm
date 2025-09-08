import sys
input = sys.stdin.readline
str1 = ' ' + input().strip()
str2 = ' ' + input().strip()

dp = [[""] * (len(str2)) for _ in range(len(str1))]

for i in range(1, len(str1)):
    for j in range(1, len(str2)):
        if str1[i] == str2[j]:
            dp[i][j] = dp[i-1][j-1] + str1[i]
        else:
            if len(dp[i][j-1]) > len(dp[i-1][j]):
                dp[i][j] = dp[i][j-1]
            else:
                dp[i][j] = dp[i-1][j]

lcs = dp[-1][-1]
print(len(lcs))
print(lcs)