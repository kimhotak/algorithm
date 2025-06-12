import sys
input = sys.stdin.readline
row, col, m = map(int,input().split())
ocean = [[False] * col for _ in range(row)]

for _ in range(m):
    r, c, speed, drct, size = map(int,input().split())
    # 방향 0인덱스 사용
    drct -= 1

    # 상어의 속도를 결과라 동치가 되도록 작은수로 변경
    if drct & 2:
        speed %= (col - 1) * 2
    else:
        speed %= (row - 1) * 2
    ocean[r-1][c-1] = (size, speed, drct)

d = ((-1,0), (1,0), (0,1), (0,-1))
size_sum = 0

for fishman in range(col):
    # 상어 잡기
    for depth in range(row):
        if not ocean[depth][fishman]: continue

        size_sum += ocean[depth][fishman][0]
        ocean[depth][fishman] = False
        break
    
    # 상어 이동
    new_ocean = [[False] * col for _ in range(row)]
    for r in range(row):
        for c in range(col):
            if not ocean[r][c]: continue

            size, speed, drct = ocean[r][c]
            nr, nc = r, c
            # [r][c]상어 이동
            for _ in range(speed):
                # 바깥으로 나가면 방향전환
                if not(0<=nr + d[drct][0]<row) or not(0<=nc + d[drct][1]<col):
                    drct ^= 1
                nr = nr + d[drct][0]
                nc = nc + d[drct][1]
            
            # 상어의 크기 비교
            if new_ocean[nr][nc] and new_ocean[nr][nc][0] > size: continue

            new_ocean[nr][nc] = (size, speed, drct)
    ocean = new_ocean

print(size_sum)