import sys
input = sys.stdin.readline

m, n = map(int, input().split())
box = [list(map(int, input().split())) for _ in range(n)]
riped = []
empty_cnt = 0
for col, line in enumerate(box):
    for row, item in enumerate(line):
        if item == 1:
            riped.append((col, row))
        elif item == -1:
            empty_cnt += 1
tomato_cnt = m * n - empty_cnt

from collections import deque

Q = deque() # (좌표, 현재 날짜)
for r in riped:
    Q.append((r, 0))
riped = set(riped)
last_date = 0
d = [(1, 0), (0, 1), (-1, 0), (0, -1)]

while Q:
    (y, x), date = Q.popleft()
    last_date = date
    for dy, dx in d:
        ny = y + dy
        nx = x + dx
        if not(0 <= ny < n) or not(0 <= nx < m):
            continue
        if (ny, nx) in riped:
            continue
        if box[ny][nx] == -1:
            continue
        Q.append(((ny,nx), date+1))
        riped.add((ny,nx))


if len(riped) == tomato_cnt:
    print(last_date)
else:
    print(-1)