import sys
input = sys.stdin.readline

n, m = map(int,input().split())
# 0-index
gods = [tuple(map(int,input().split())) for _ in range(n)]
# 1-index
road = [tuple(sorted(map(int,input().split()))) for _ in range(m)]

def calc_dist(a, b):
    ax, ay = a
    bx, by = b
    return (abs(ax-bx)**2 + abs(ay-by)**2)**(1/2)

graph = []
for i in range(n-1):
    for j in range(i+1,n):
        graph.append((calc_dist(gods[i], gods[j]), i+1, j+1))

for n1, n2 in road:
    graph.append((0, n1, n2))
graph.sort()

# 자료구조로 생각하는게 더 편할듯
parent = [i for i in range(n+1)]

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(x,y):
    x = find(x)
    y = find(y)
    if x != y:
        parent[y] = x
        return True
    return False

answer = 0
for cost, n1, n2 in graph:
    if union(n1,n2):
        answer += cost

print(f'{answer:.2f}')