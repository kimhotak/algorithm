import sys
import heapq
input = sys.stdin.readline

n, e = map(int, input().split())
edge = {i : dict() for i in range(1, n+1)}
for _ in range(e):
    a, b, c  = map(int, input().split())
    edge[a][b] = c
    edge[b][a] = c

v1, v2 = map(int, input().split())


def dijkstra(start, points):
    pq = []
    heapq.heappush(pq, (0, start))
    visited = [float('inf') for _ in range(n+1)]
    visited[start] = 0

    while pq:
        cost, start = heapq.heappop(pq)
        for end, add_cost in edge[start].items():
            if visited[end] <= cost + add_cost:
                continue
            visited[end] = cost + add_cost
            heapq.heappush(pq, (cost + add_cost, end))
    return [visited[p] for p in points]

from_1 = dijkstra(1, [v1, v2])
between_v = dijkstra(v1, [v2, v2])
from_n = dijkstra(n, [v2, v1])

res = min(from_1[i] + between_v[i] + from_n[i] for i in range(2))

print(res if res != float('inf') else -1)