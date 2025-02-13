import sys
import math
input = sys.stdin.readline
n = int(input())
if n == 0:
    print(0)
    exit()

def round(n):
    return math.ceil(n) if n%1 >= 0.5 else math.floor(n)

A = [int(input()) for _ in range(n)]
A.sort()
m = round(n*15/100)
print(round(sum(A[m:n-m])/(n-2*m)))