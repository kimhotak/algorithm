import sys
input = sys.stdin.readline

n, m, h = map(int, input().split())
bar = [[0] * (n-1) for _ in range(h)]

for _ in range(m):
    a, b = map(int, input().split())
    bar[a-1][b-1] = 1

full = h * (n - 1)

def dfs(start, depth):
    num = list(range(n))
    for a in range(h):
        for b in range(n-1):
            if bar[a][b]:
                num[b], num[b+1] = num[b+1], num[b]
    if num == list(range(n)):
        return depth

    if depth == 3:
        return 4

    res = 4
    for i in range(start, full):
        a, b = divmod(i, n-1)
        if bar[a][b]:
            continue
        if b-1 >= 0 and bar[a][b-1]:
            continue
        if b+1 < n-1 and bar[a][b+1]:
            continue
        bar[a][b] = 1
        res = min(res, dfs(i + 1, depth + 1))
        bar[a][b] = 0
    return res

res = dfs(0, 0)
print(res if res <= 3 else -1)
