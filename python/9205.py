import sys
input = sys.stdin.readline
t = int(input())

def CanGo(ax, ay, bx, by):
    return abs(ax - bx) + abs(ay - by) <= 1000

for _ in range(t):
    n = int(input())
    home = tuple(map(int,input().split()))
    store = [tuple(map(int,input().split())) for _ in range(n)]
    party = tuple(map(int,input().split()))
    visited = set()
    visited.add(home)

    stack = []
    stack.append(home)
    while stack:
        x, y = stack.pop()
        if CanGo(x, y, *party):
            print('happy')
            break
        for nx, ny in store:
            if (nx, ny) in visited:
                continue
            if not CanGo(x, y, nx, ny):
                continue
            stack.append((nx, ny))
            visited.add((nx, ny))

    else:
        print('sad')