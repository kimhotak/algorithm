import sys
input = sys.stdin.readline

n, m = map(int, input().split())
INF = float('inf')

edge = [list(map(int, input().split())) for _ in range(m)]

dist = [INF] * (n + 1)
parent = [None] * (n + 1)
dist[1] = 0

for _ in range(m-1):
    updated = False
    for s, e, cost in edge:
        if dist[s] != INF and dist[s] + cost < dist[e]:
            dist[e] = dist[s] + cost
            parent[e] = s
            updated = True
    if not updated:
        break

hasNegCycle = False
for s, e, cost in edge:
    if dist[s] != INF and dist[s] + cost < dist[e]:
        hasNegCycle = True

if hasNegCycle:
    print(-1)
else:
    for i in range(2, n+1):
        if dist[i] == INF:
            print(-1)
        else:
            print(dist[i])
