import sys
n = list(map(int, sys.stdin.read().split()))
print(sum(n)//5)
print(sorted(n)[2])