import sys
input = sys.stdin.readline

def find(N, M):
    l = [0]*(M+1)
    l[0] = 1
    for n in N:
        for m in range(n,M+1):
            l[m] += l[m-n]
    return l[M]

T = int(input())
for _ in range(T):
    n = int(input()) # 동전의 가짓수
    N = list(map(int,input().split())) # 동전의 각 금액 오름차순
    M = int(input()) # 만들어야 하는 금액
    print(find(N,M))