import sys
import heapq

n, k = map(int, sys.stdin.readline().split())
s = list(map(int, sys.stdin.readline().split()))
# heapq.heapify(s)
print(heapq.nlargest(k,s)[-1])