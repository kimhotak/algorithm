import sys
import heapq
from collections import defaultdict
input = sys.stdin.readline

n = int(input())
days_values = defaultdict(list)

for i in range(n):
    d, v = map(int, input().split())
    days_values[d].append(v)

last_day= max(days_values.keys())

hq = []
res = 0
for day in range(last_day, 0, -1):
    for value in days_values[day]:
        heapq.heappush(hq, -value) # -로 큰것 부터 나오게
    if len(hq):
        res -= heapq.heappop(hq) # push에서 -해서 -=

print(res)