import sys
from itertools import combinations

input = sys.stdin.readline

n, m = map(int, input().split())
town_map = [list(map(int, input().split())) for _ in range(n)]

houses = []
chickens = []

# 좌표 수집
for i in range(n):
    for j in range(n):
        if town_map[i][j] == 1:
            houses.append((i, j))  # 행, 열 = y, x
        elif town_map[i][j] == 2:
            chickens.append((i, j))

min_dist = float('inf')

# 치킨집 조합 중에서 최소 도시 치킨 거리 계산
for comb in combinations(chickens, m):
    total = 0
    for hx, hy in houses:
        dist = min(abs(hx - cx) + abs(hy - cy) for cx, cy in comb)
        total += dist
    min_dist = min(min_dist, total)

print(min_dist)
