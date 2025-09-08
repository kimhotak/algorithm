import sys

n = int(sys.stdin.readline())
num = []
for i in range(n):
    num.append(list(map(int, sys.stdin.readline().split())))
num.sort()
for i in num:
    print(' '.join(map(str,i)))