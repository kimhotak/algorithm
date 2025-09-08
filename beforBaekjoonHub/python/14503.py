import sys
input = sys.stdin.readline

N, M = map(int, input().split())
r, c, d = map(int, input().split())
room = [list(map(int, input().split())) for _ in range(N)]

dr = (-1, 0, 1, 0)
dc = ( 0, 1, 0,-1)
cleaned = 0

while True:
    # 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
    if room[r][c] == 0:
        room[r][c] = 2
        cleaned += 1
    
    for i in range(4):
        d = (d - 1) % 4
        # 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
        if room[r + dr[d]][c + dc[d]] == 0:
            r += dr[d]
            c += dc[d]
            break
    # 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
    else:
        reverse_d = (d + 2) % 4
        r = r + dr[reverse_d]
        c = c + dc[reverse_d]
        # 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춤
        if room[r][c] == 1:
            break

print(cleaned)