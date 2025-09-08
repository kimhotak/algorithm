import sys
input = sys.stdin.readline
n = int(input())
matrix = [list(map(int, input().split())) for _ in range(n)]

# matrix.append([6, 1])
# n += 1

dp = [[0] * n for _ in range(n)]

for i in range(n):
    for j in range(i+1,n):
        dp[i][j] = matrix[i][0] * matrix[j][0] * matrix[j][1] + dp[i][j-1]

for i in dp:
    print(i)