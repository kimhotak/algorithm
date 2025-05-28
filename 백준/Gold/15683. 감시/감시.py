import sys
import copy
input = sys.stdin.readline

# 데이터 입력
n, m = map(int, input().split())
room = [list(map(int, input().split())) for _ in range(n)]

# cctv 위치 파악
cctv = [] # (y, x, cctv종류)
for i in range(n):
    for j in range(m):
        if 0 < room[i][j] < 6:
            cctv.append((i, j, room[i][j]))

# 하 우 상 좌
dy = (1,0,-1,0)
dx = (0,1,0,-1)

# cctv가 보는 방향 -1 채우기
def fill(r, y, x, dir):
    while (0 <= y < n) and (0 <= x < m) and r[y][x] != 6:
        if r[y][x] == 0:
            r[y][x] = -1
        y += dy[dir]
        x += dx[dir]
    return

# cctv 번호별 방향
dirs = [
    [],
    [[0], [1], [2], [3]],                           # 1번 CCTV
    [[0, 2], [1, 3]],                               # 2번
    [[0, 1], [1, 2], [2, 3], [3, 0]],               # 3번
    [[0, 1, 2], [1, 2, 3], [2, 3, 0], [3, 0, 1]],   # 4번
    [[0, 1, 2, 3]],                                 # 5번
]

# cctv가 보는 방향의 종류로 dfs
stack  = []
stack.append((0, room))
min_blind = float('inf')

while stack:
    idx, current_room = stack.pop()
    if idx >= len(cctv):
        min_blind = min(min_blind, sum(r.count(0) for r in current_room))
        continue
    y, x, cctv_type = cctv[idx]

    for dir in dirs[cctv_type]:
        new_room = copy.deepcopy(current_room)
        for d in dir:
            fill(new_room, y, x, d)
        stack.append((idx+1, new_room))

print(min_blind)