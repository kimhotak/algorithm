import heapq
import sys

n = list(map(int, sys.stdin.read().split()))[1:]

heapq.heapify(n)
while n:
    print(heapq.heappop(n))