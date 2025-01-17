import sys
input = sys.stdin.readline
n, m = map(int, input().split())
mars = [list(map(int, input().split())) for _ in range(n)]

dp = [None] * m
s = 0
for i in range(m):
    s += mars[0][i]
    dp[i] = s

for i in range(1,n):
    left = [-float('inf')] * m
    right = [-float('inf')] * m
    # 좌 -> 우
    for j in range(m):
        if j == 0:
            right[j] = dp[j] + mars[i][j]
        else:
            right[j] = max(dp[j] + mars[i][j], right[j-1] + mars[i][j])

    # 우 -> 좌
    for j in range(m-1,-1,-1):
        if j == m-1:
            left[j] = dp[j] + mars[i][j]
        else:
            left[j] = max(dp[j] + mars[i][j], left[j+1] + mars[i][j])
    
    # 병합 수정
    for j in range(m):
        dp[j] = max(left[j], right[j])

print(dp[-1])