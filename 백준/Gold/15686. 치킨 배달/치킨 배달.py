import sys
from itertools import combinations

input = sys.stdin.readline()
n, m = input.split()

input = sys.stdin.readlines()
town_map = list( list(j for j in i.split()) for i in input)

chickins = []
houses = []

for col_idx, map_row in enumerate(town_map):
    for row_idx, map_point in enumerate(map_row):
        if map_point == '1':
            houses.append((col_idx, row_idx))
        elif map_point == '2':
            chickins.append((col_idx, row_idx))

chickin_dist = [[] for _ in range(len(chickins))]
for idx, chickin in enumerate(chickins):
    for house in houses:
        chickin_dist[idx].append(abs(house[0]-chickin[0]) + abs(house[1]-chickin[1]))

answer = []
for comb in combinations(chickin_dist,int(m)):
    answer.append(sum(min(i) for i in map(list, zip(*comb))))

print(min(answer))