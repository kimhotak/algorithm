import sys
from collections import Counter
input = sys.stdin.readline

n, m = map(int, input().split())

score = [0] * n
vote = [list(input().strip()) for _ in range(n)]


for i in range(m):
    v = [vote[j][i] for j in range(n)]
    cnt = Counter(v)

    minority = '1'
    if cnt['0'] < n/2:
        minority = '0'

    for i in range(n):
        if v[i] == minority:
            score[i] += 1

high = max(score)

print(*[i+1 for i in range(n) if score[i] == high])