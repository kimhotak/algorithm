import sys
import heapq
input = sys.stdin.readline

n, m = map(int, input().split())

output_edge = [[] for _ in range(n+1)]
input_edge = [-1] + [0 for _ in range(n)]

for _ in range(m):
    a, b = map(int, input().split())
    output_edge[a].append(b)
    input_edge[b] += 1

front_num = []
for node in range(n+1):
    if input_edge[node] == 0:
        heapq.heappush(front_num, node)

res = []
while front_num:
    node = heapq.heappop(front_num)
    for next_node in output_edge[node]:
        input_edge[next_node] -= 1
        if input_edge[next_node] == 0:
            heapq.heappush(front_num, next_node)
    res.append(node)

print(' '.join(map(str,res)))