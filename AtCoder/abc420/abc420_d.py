import sys
from collections import deque
input = sys.stdin.readline

h, w = map(int, input().split())
maze = [list(input().strip()) for _ in range(h)]
visited = [[[False] * w for _ in range(h)] for _ in range(2)]
# 0은 untoggled

q = deque()
outq = deque()

for r in range(h):
    for c in range(w):
        if maze[r][c] == 'S':
            outq.append((r,c, False))
            visited[0][r][c] = True

d = ((1,0), (0,1), (-1,0), (0,-1))

res = 0
isEnd = False
while outq and not isEnd:
    q = outq
    outq = deque()
    while q:
        r, c, toggled = q.popleft()

        for dr, dc in d:
            nr, nc = r + dr, c + dc
            if not(0 <= nr < h) or not(0 <= nc < w):
                continue
            elif maze[nr][nc] == '#':
                continue
            elif maze[nr][nc] == 'o' and toggled:
                continue
            elif maze[nr][nc] == 'x' and not toggled:
                continue

            nToggled = toggled
            if maze[nr][nc] == '?':
                nToggled = not toggled
                
            if visited[int(nToggled)][nr][nc]:
                continue

            if maze[nr][nc] == 'G':
                isEnd = True
            outq.append((nr, nc, nToggled))
            visited[int(nToggled)][nr][nc] = True
    res += 1
    if isEnd:
        break

print(res if isEnd else -1)