from collections import deque
import sys

input = sys.stdin.readline

n, m = map(int, input().split())
jido = [list(map(int, input().split())) for _ in range(n)]

dist_map = [[0 if jido[i][j] == 0 else -1 for j in range(m)] for i in range(n)]

for i in range(n):
    for j in range(m):
        if jido[i][j] == 2:
            start = (i, j)

q = deque()
q.append(start)
visited = [[False]*m for _ in range(n)]
visited[start[0]][start[1]] = True
dist_map[start[0]][start[1]] = 0

while q:
    x, y = q.popleft()
    for dx, dy in ((1,0), (0,1), (-1,0), (0,-1)):
        nx, ny = x + dx, y + dy
        if 0 <= nx < n and 0 <= ny < m:
            if not visited[nx][ny] and jido[nx][ny] == 1:
                visited[nx][ny] = True
                dist_map[nx][ny] = dist_map[x][y] + 1
                q.append((nx, ny))

for row in dist_map:
    print(' '.join(map(str, row)))
