import sys
from collections import defaultdict
input = sys.stdin.readline
num = int(input())
num_edge = int(input())
edge = defaultdict(list)
for _ in range(num_edge):
    a, b = map(int, input().split())
    edge[a].append(b)
    edge[b].append(a)

stack = []
visited = set()
stack.append(1)
visited.add(1)
warmed = 0
while stack:
    node = stack.pop()
    for next_node in edge[node]:
        if next_node in visited:
            continue
        warmed += 1
        stack.append(next_node)
        visited.add(next_node)

print(warmed)