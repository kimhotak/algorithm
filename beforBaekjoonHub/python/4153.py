import sys
input = sys.stdin.readline

while True:
    edges = sorted(list(map(int,input().split())))
    if not any(edges):
        break
    if edges[0]**2 + edges[1]**2 == edges[2]**2:
        print('right')
    else:
        print('wrong')
    