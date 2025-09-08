import sys
import heapq
input = sys.stdin.readline

n, m = map(int, input().split())

graph = [[] for _ in range(n+1)]
indegree = [0] * (n + 1)

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    indegree[b] += 1

hq = []
for i in range(1, n+1):
    if indegree[i] == 0:
        heapq.heappush(hq, i)

res = []
while hq:
    curr_node = heapq.heappop(hq)
    res.append(curr_node)
    for next_node in graph[curr_node]:
        indegree[next_node] -= 1
        if indegree[next_node] == 0:
            heapq.heappush(hq, next_node)

print(*res)