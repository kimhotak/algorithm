import sys
input = sys.stdin.readline
n = int(input())
grid = [list(map(int,input().split())) for _ in range(n)]
# 0: 세로, 1: 가로, 2: 대각선
d = ((1, 0), (0, 1), (1, 1))
res = 0

stack = []
stack.append((0, 1, 1))
# head의 좌표 r , c, 상태
while stack:
    r, c, state = stack.pop()
    for next_state, (dr, dc) in enumerate(d):
        if state == 1 and next_state == 0:
            continue # 가로에서 세로로 꺾는 경우
        elif state == 0 and next_state == 1:
            continue # 세로에서 가로로 꺾는경우
        elif next_state == 2:
            # 대각선으로 꺾는 경우
            if r+1 < n and grid[r + 1][c]:
                continue # 아래 칸 벽 사전 확인
            if c+1 < n and grid[r][c + 1]:
                continue # 오른쪽 칸 벽 사전 확인

        nr, nc = r + dr, c + dc
        if not((nr < n) and (nc < n)):
            continue # 범위 밖인 경우
        elif grid[nr][nc] == 1:
            continue # 다음 칸이 벽인 경우

        if nr == n-1 and nc == n-1:
            res += 1
            continue # 도착지에 도달한 경우
        else:
            stack.append((nr, nc, next_state))

print(res)