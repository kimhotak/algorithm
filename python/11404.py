import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
edge = [[float('inf') if i != j else 0 for j in range(n)] for i in range(n)]

for _ in range(m):
    a, b, c = map(int, input().split())
    a -= 1
    b -= 1
    edge[a][b] = min(edge[a][b], c)

for i in range(n):
    for j in range(n):
        for k in range(n):
            if edge[j][k] > edge[j][i] + edge[i][k]:
                edge[j][k] = edge[j][i] + edge[i][k]
            if edge[k][j] > edge[k][i] + edge[i][j]:
                edge[k][j] = edge[k][i] + edge[i][j]

for i in range(n):
    for j in range(n):
        if edge[i][j] == float('inf'):
            edge[i][j] = 0

for i in range(n):
    print(*edge[i])