import sys
import heapq

input = sys.stdin.readline
n, m = map(int, input().split())
# n : 세로
# m : 가로

# 2에서 출발해서 각 지점까지의 거리를 모으는것이 편할듯

# 2위치 찾기
jido = []
two = []
dist_map = []
for i in range(n):
    tmp = list(map(int, input().split()))
    jido.append(tmp)
    if 2 in tmp:
        two = [i, tmp.index(2)]
    dist_map.append([-1 if t==1 else 0 for t in tmp])

hq = []
# (거리, 현재좌표, [지나온 길])
heapq.heapify(hq)
heapq.heappush(hq, (0, two, [two]))

while hq:
    dist, idx, path = heapq.heappop(hq)

    if dist_map != -1 and dist_map[idx[0]][idx[1]] > dist:
        continue

    dist_map[idx[0]][idx[1]] = dist

    for midx, move in enumerate(((1,0), (0,1), (-1,0), (0,-1))):
        move_idx = [idx[0]+move[0], idx[1]+move[1]]

        if dist_map[move_idx[0], move_idx[1]] == 0:
            continue
        if move_idx in path:
            continue
        if move_idx[0] < 0 or move_idx[1] < 0 or move_idx[0]:
            continue
        if midx == 0 and move_idx[0] > n:
            continue
        if midx == 1 and move_idx[0] > m:
            continue

        heapq.heappush(hq, (dist+1, move_idx, path.append(move_idx) ))

print(dist_map)