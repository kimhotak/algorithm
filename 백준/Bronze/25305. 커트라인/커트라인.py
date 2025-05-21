import sys

n, k = map(int, sys.stdin.readline().split())
s = list(map(int, sys.stdin.readline().split()))
print(sorted(s,reverse=True)[k-1])