import sys
input = sys.stdin.readline
k, n = map(int,input().split())
line = [int(input()) for _ in range(k)]

left, right = 1, max(line)
while left <= right:
    mid = (left + right)//2
    tmp = sum(l//mid for l in line)
    if tmp >= n:
        left = mid + 1
    else:
        right = mid - 1
print(left -1 )