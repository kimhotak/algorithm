import sys
input = sys.stdin.readline

n, m, k = map(int, input().split())

res = ''

man = [0] * (n + 1)
for _ in range(k):
    a, _ = map(int, input().split())
    man[a] += 1
    if man[a] == m:
        res += str(a) + ' '

print(res)