import sys
input = sys.stdin.readline
n = int(input())
A = list(map(int,input().split()))

current = A[0]
answer = A[0]
for a in A[1:]:
    current = max(a, current + a)
    answer = max(current, answer)
print(answer)