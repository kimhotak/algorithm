import sys
from collections import deque
input = sys.stdin.readline

n, r = map(int, input().split())
l = deque(map(int, input().split()))

# 왼쪽 끝으로 가서 잠구거나 오른쪽 끝으로 가서 잠궈야함
while l and l[0] == 1 and r > 0:
    l.popleft()
    r -= 1
    n -= 1

while l and l[-1] == 1 and r < n:
    l.pop()
    n -= 1

res = 0
for i in range(n):
    if l[i]:
        res += 2
    else:
        res += 1

print(res)