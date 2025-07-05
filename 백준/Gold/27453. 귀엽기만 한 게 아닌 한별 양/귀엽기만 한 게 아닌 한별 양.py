import sys
input = sys.stdin.readline
n, m, k = map(int, input().split())
start, end = None, None
town = [[] for _ in range(n)]

for i in range(n):
    for j, item in enumerate(input().strip()):
        if item.isdigit():
            town[i].append(int(item))
        elif item == 'S':
            start = (i,j)
            town[i].append(0)
        elif item == 'H':
            end = (i,j)
            town[i].append(0)
        else:
            town[i].append(-1)
            
from collections import deque
Q = deque()
# 좌표, 이전좌표, 거리
Q.append((start, start, 0))
# 좌표, 이전의 불상사 값
visited = set()
visited.add((start, start))
d = ((1, 0), (0, 1), (-1, 0), (0, -1))

while Q:
    (y, x), (by, bx), dist = Q.popleft()
    if (y, x) == end:
        print(dist)
        break

    for dy, dx in d:
        ny, nx = y+dy, x+dx
        if not(0<=ny<n) or not(0<=nx<m):
            continue
        elif by == ny and bx == nx:
            continue
        elif town[ny][nx] == -1:
            continue
        elif town[by][bx] + town[y][x] + town[ny][nx] > k:
            continue
        elif ((ny, nx), (y, x)) in visited:
            continue

        Q.append(((ny, nx), (y, x), dist+1))
        visited.add(((ny, nx), (y, x)))
else:
    print(-1)