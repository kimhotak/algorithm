import sys
from collections import deque
input = sys.stdin.readline
M, N, H = map(int, input().split())
box = [[list(map(int, input().split())) for _ in range(N)] for _ in range(H)]

d = ((1,0,0), (-1,0,0), (0,1,0), (0,-1,0), (0,0,1), (0,0,-1))
Q = deque()
cnt = M * N * H

for h in range(H):
    for n in range(N):
        for m in range(M):
            if box[h][n][m] == 1:
                Q.append((h,n,m,0))
                cnt -= 1
            elif box[h][n][m] == -1:
                cnt -= 1

while Q:
    z, y, x, day = Q.popleft()
    for dz, dy, dx in d:
        nz, ny, nx = dz+z, dy+y, dx+x
        if not(0 <= nz < H) or not(0 <= ny < N) or not(0 <= nx < M):
            continue
        if box[nz][ny][nx] != 0:
            continue
        box[nz][ny][nx] = 1
        cnt -= 1
        Q.append((nz, ny, nx, day+1))

print(-1 if cnt else day)