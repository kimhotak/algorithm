import sys
input = sys.stdin.readline

n = int(input())
l = list(map(int, input().split()))

left = 0
while left < n and l[left] == 0:
    left += 1

right = n-1
while right >= 0 and l[right] == 0:
    right -= 1

if left > right:
    print(0)
else:
    print(right - left)