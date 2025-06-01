import sys
input = sys.stdin.readline
n, m, k = map(int, input().split())
start, end = None, None
town = [[] for _ in range(n)]

for i in range(n):
    for j in input().strip():
        if j.isdigit():
            town[i].append(int(j))
        elif j == 'S':
            start = (i,j)
            town[i].append(0)
        elif j == 'H':
            end = (i,j)
            town[i].append(0)
        else:
            town[i].append(-1)
print(n,m,k)
print(town)
print(start,end)

dx = (0, 1, 0, -1)
dy = (1, 0, -1, 0)

from collections import deque
Q = deque()
# 이전 좌표, 
Q.append(start, 0, 0)
# 좌표, 
visited = set()
visited.add((start, 0))

while Q:
