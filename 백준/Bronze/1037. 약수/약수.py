import sys
input = sys.stdin.readline
n = input()
a = sorted(map(int, input().split()))
print(a[0]*a[-1])