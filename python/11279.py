import sys
import heapq
input = sys.stdin.readline

n = int(input())
hq = []
for _ in range(n):
    op = int(input())
    if op:
        heapq.heappush(hq,-op)
    else:
        if hq:
            print(-heapq.heappop(hq))
        else:
            print(0)