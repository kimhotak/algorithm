import sys
input = sys.stdin.readline

h, w = map(int, input().split())
grid = [list(input().strip()) for _ in range(h)]
# #이 검은색
d = ((0,1), (0,-1), (1,0), (-1,0))

res = True
for i in range(h):
    for j in range(w):
        if grid[i][j] == '.':
            continue
        cnt = 0
        for dx, dy in d:
            ni = i+dx
            nj = j+dy
            if not(0 <= ni < h) or not(0 <= nj < w):
                continue
            if grid[ni][nj] == '#':
                cnt += 1
        if cnt != 2 and cnt != 4:
            res = False

print('Yes' if res else 'No')