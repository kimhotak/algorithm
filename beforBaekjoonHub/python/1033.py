import sys
import math
from collections import deque
input = sys.stdin.readline

n = int(input())
graph = [[] for _ in range(n)]
for _ in range(n-1):
    a, b, p, q = map(int, input().split())
    graph[a].append((b, p, q))
    graph[b].append((a, q, p))

# 기준 재료를 인덱스 0, visited처럼 활용
ratio = [None] * n
ratio[0] = [1, 1]

Q = deque()
Q.append(0)
while Q:
    a = Q.popleft()
    for b, p, q in graph[a]:
        if ratio[b]:
            # 이미 기준재료 대비 비율 구한 경우
            continue

        top = ratio[a][0] * p
        bot = ratio[a][1] * q
        gcd = math.gcd(top, bot)
        ratio[b] = [top//gcd, bot//gcd]

        Q.append(b)

lcm = math.lcm(*(top for top, bot in ratio))
mass = [lcm // top * bot for top, bot in ratio]

print(' '.join(map(str,mass)))