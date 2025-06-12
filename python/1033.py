import sys
import math
from collections import deque
input = sys.stdin.readline

n = int(input())

graph = [[None] * n for i in range(n)]
for _ in range(n-1):
    a, b, p, q = map(int, input().split())
    graph[a][b] = (p, q)
    graph[b][a] = (q, p)

#기준질량을 0으로 잡음
base = [None] * n
base[0] = (1, 1)

Q = deque()
Q.append(0)
while Q:
    node = Q.popleft()
    for next_node, ratio in enumerate(graph[node]):
        if not graph[node][next_node]:
            continue
        elif base[next_node]:
            continue
        base[next_node] = tuple(i*j for i,j in zip(base[node], graph[node][next_node]))
        div = math.gcd(*base[next_node])
        base[next_node] = tuple(i//div for i in base[next_node])

        Q.append(next_node)

base[0] = math.lcm(*(b[0] for b in base))
for i in range(1,n):
    base[i] = base[0] // base[i][0] * base[i][1]
print(' '.join(map(str,base)))