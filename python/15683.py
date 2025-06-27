import sys
input = sys.stdin.readline
n, m = map(int, input().split())

room = []
cctv = [] # (y, x, cctv종류)
wall = 0

for i in range(n):
    tmp = []
    for j, v in enumerate(map(int, input().split())):
        tmp.append(v)
        if 0 < v < 6:
            cctv.append([i, j, v])
        elif v == 6:
            wall += 1
    room.append(tmp)


# 해당 인덱스의 cctv가 볼수 있는 공간의 좌표 set
# dir 순서와 같음
cctv_view = []
dir = ((1,0),(0,1),(-1,0),(0,-1))
for y, x, _ in cctv:
    tmp = []
    for dy, dx in dir:
        ny, nx = y, x
        can_view_dir = set()
        while (0 <= ny < n) and (0 <= nx < m) and room[ny][nx] != 6:
            can_view_dir.add((ny, nx))
            ny += dy
            nx += dx
        tmp.append(can_view_dir)
    cctv_view.append(tmp)

max_view = -1
all_cctv_case = (None,
                    ((0,),(1,),(2,),(3,)), # 1번
                    ((0, 2),(1, 3)), # 2번
                    ((0,1),(1,2),(2,3),(3,0)), # 3번
                    ((0,1,2),(1,2,3),(2,3,0),(3,0,1)), # 4번
                    ((0,1,2,3),) # 5번
                )
stack = [] # cctv 순서, 현재 볼수 있는 set
stack.append((0, set()))

while stack:
    cctv_idx, can_see = stack.pop()

    if cctv_idx >= len(cctv):
        max_view = max(max_view, len(can_see))
        continue

    cctv_type = cctv[cctv_idx][2]
    
    for cctv_case in all_cctv_case[cctv_type]:
        new_see = can_see.copy()
        for c in cctv_case:
            new_see |= cctv_view[cctv_idx][c]
            stack.append((cctv_idx+1, new_see))

print(n * m -max_view -wall)
