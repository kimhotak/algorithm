import sys
input = sys.stdin.readline

n,k = map(int,input().split())
A = list(int(input()) for _ in range(n))

answer = 0
while k > 0:
    coin = A.pop()
    tmp = k//coin
    k %= coin
    answer += tmp

print(answer)