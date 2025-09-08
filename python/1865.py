import sys
input = sys.stdin.readline

tc = int(input())
INF = float('inf')

for _ in range(tc):
    n, m, w = map(int, input().split())

    edge = []

    for _ in range(m):
        s, e, t = map(int, input().split())
        edge.append((s-1, e-1, t))
        edge.append((e-1, s-1, t))
    for _ in range(w):
        s, e, t = map(int, input().split())
        edge.append((s-1, e-1, -t))

    dist = [INF] * n
    while INF in dist:
        for i in range(n):
            dist[i] = 0

        for i in range(n-1):
            for s, e, cost in edge:
                if dist[s] != INF and dist[s] + cost < dist[e]:
                    dist[e] = dist[s] + cost
    
    isNegCycle = False
    for s, e, cost in edge:
        if dist[s] != INF and dist[s] + cost < dist[e]:
            isNegCycle = True
        
    print('YES' if isNegCycle else 'NO')



# print(500**3 * 5)
# 625000000

# 웜홀은 단방향
# 다른 지점까지 가는 곳까지 음수여도 다시 돌아왔을 때 음수라는 보장 X
# 음수 사이클 가능하냐?