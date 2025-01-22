import sys
input = sys.stdin.readline

n, m = map(int, sys.stdin.readline().split())

a = [list(map(int, input().split())) for _ in range(n)]
b = [list(map(int, input().split())) for _ in range(n)]

c = list(list(str(z+w) for z,w in zip(x,y)) for x,y in zip(a,b))

for i in c:
    print(' '.join(i))