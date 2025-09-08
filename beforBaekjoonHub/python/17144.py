import sys
input = sys.stdin.readline

R, C, T = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(R)]

# 클리너의 위치 [0]: 위 [1]: 아래
cleaner = []
for r in range(R):
    if grid[r][0] == -1:
        cleaner.append(r)

for _ in range(T):
    # 미세먼지 확산
    new_grid = [[0] * C for _ in range(R)]
    for r in range(R):
        for c in range(C):

            if grid[r][c] == -1:
                new_grid[r][c] = -1
                continue

            spread = grid[r][c] // 5
            cnt = 0
            for dr, dc in ((-1,0),(0,-1),(1,0),(0,1)):
                nr, nc = r + dr, c + dc
                if 0 <= nr < R and 0 <= nc < C and grid[nr][nc] != -1:
                    new_grid[nr][nc] += spread
                    cnt += 1
            new_grid[r][c] += grid[r][c] - spread * cnt
    grid = new_grid

    # 공기청정기 작동
    # 위쪽(반시계)
    top = cleaner[0]
    # 왼쪽 세로 위로
    for i in range(top-1, 0, -1):
        grid[i][0] = grid[i-1][0]
    # 윗줄 왼->오
    for i in range(C-1):
        grid[0][i] = grid[0][i+1]
    # 오른쪽 세로 아래로
    for i in range(top):
        grid[i][C-1] = grid[i+1][C-1]
    # 아래줄 오->왼
    for i in range(C-1, 0, -1):
        grid[top][i] = grid[top][i-1]
    grid[top][1] = 0

    # 아래쪽(시계)
    bottom = cleaner[1]
    # 왼쪽 세로 아래로
    for i in range(bottom+1, R-1):
        grid[i][0] = grid[i+1][0]
    # 아랫줄 왼->오
    for i in range(C-1):
        grid[R-1][i] = grid[R-1][i+1]
    # 오른쪽 세로 위로
    for i in range(R-1, bottom, -1):
        grid[i][C-1] = grid[i-1][C-1]
    # 윗줄 오->왼
    for i in range(C-1, 0, -1):
        grid[bottom][i] = grid[bottom][i-1]
    grid[bottom][1] = 0

    grid[top][0] = -1
    grid[bottom][0] = -1

print(sum(sum(row) for row in grid) + 2)