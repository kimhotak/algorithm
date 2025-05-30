import sys

input = sys.stdin.readline
n = int(input())
N = sorted(list(map(int, input().split())))
m = int(input())
M = list(map(int, input().split()))
for i in M:
    left, mid, right = 0, n//2, n
    while left < right:
        if N[mid] == i:
            print(1)
            break
        elif N[mid] > i:
            right = mid
        else:
            left = mid+1
        mid = left + (right - left) // 2
    else:
        print(0)