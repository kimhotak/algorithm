import sys

n = list(map(int, sys.stdin.read().split()))
n.sort()
if n[2] >= n[0]+n[1]:
    n[2] = n[0]+n[1]-1
print(sum(n))