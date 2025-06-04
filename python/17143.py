import sys
input = sys.stdin.readline
r, c, m = map(int,input().split())
shark = []
for _ in range(m):
    shark.append(list(map(int,input().split())))
    # y, x, 속력, 이동방향, 크기
