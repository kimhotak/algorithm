import sys
from collections import deque
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

# 이거 방문했을 때 거리 저장해야할듯 같은 불상사의 개수에서?
short = [[[k for _ in range(m)] for _ in range(n)] for _ in range(k)]

q = deque()
# 이동한거리, 막은 불상사 수, 이전 좌표
q.append(0, 0, start)

while q:
