import sys
import heapq

input = sys.stdin.readline

bag = []
q = int(input())
for _ in range(q):
    query = list(map(int,input().split()))
    if query[0] == 1:
        heapq.heappush(bag, query[1])
    else:
        print(heapq.heappop(bag))