n = int(input())
A = [int(1<i<=3) for i in range(n+1)]

for i in range(4,n+1):
    tmp = A[i-1] + 1
    if i % 3 == 0:
        tmp = min(tmp, A[i//3] + 1)
    if i % 2 == 0:
        tmp = min(tmp, A[i//2] + 1)
    A[i] = tmp

print(A[-1])