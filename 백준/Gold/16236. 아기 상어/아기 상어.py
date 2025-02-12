import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
sea = [list(map(int,input().split())) for _ in range(N)]
sec = 0
# 상어의 정보
size = 2
ate_cnt = 0
location = tuple()

# 상어의 위치 찾기
for i in range(N):
    for j in range(N):
        if sea[i][j] == 9:
            location = (i, j)
            sea[i][j] = 0

dy = (-1,0, 0, 1)
dx = (0,-1, 1, 0)
Q = deque()
visited = set()
ate_flag = True

while ate_flag:
    # 한 위치에서 먹을 물고기 찾는 bfs
    ate_flag = False
    tmp_Q = deque()
    tmp_sec = 0
    Q.append((location))
    visited.add(location)
    while Q:
        can_eat = []
        while Q:
            (y, x) = Q.popleft()
            for i in range(4):
                ny = y + dy[i]
                nx = x + dx[i]
                # 바다 밖 처리
                if not((0 <= ny < N) and (0 <= nx < N)):
                    continue
                # 재방문 X 처리
                if (ny,nx) in visited:
                    continue
                # 자기보다 큰 물고기 못지나감 처리
                if sea[ny][nx] > size:
                    continue
                # 물고기 찾음
                if 0 < sea[ny][nx] < size:
                    can_eat.append((ny,nx))
                tmp_Q.append((ny,nx))
                visited.add((ny,nx))

        if can_eat:
            y, x = min(can_eat)
            location = (y, x)
            sea[y][x] = 0
            ate_cnt += 1
            if ate_cnt == size:
                size += 1
                ate_cnt = 0
            ate_flag = True
            sec += tmp_sec + 1
            Q.clear()
            visited.clear()
        else:
            Q, tmp_Q = tmp_Q, Q
            tmp_sec += 1
print(sec)
