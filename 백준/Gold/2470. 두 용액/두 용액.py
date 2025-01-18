import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
l = sorted(list(map(int,input().split())))
l = deque(l)
comb = None
small = float('inf')
while len(l) > 1:
    tmp = l[0] + l[-1]
    if abs(tmp) < small:
        small = abs(tmp)
        comb = (l[0], l[-1])
    if tmp > 0:
        l.pop()
    else:
        l.popleft()

print(' '.join(map(str,comb)))