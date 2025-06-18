import sys
input = sys.stdin.readline
N, M = map(int, input().split())
nums = [int(input()) for _ in range(N)]
dp = [[float('inf')] * (N+1) for _ in range(M+1)]

for m in range(1, M+1):
    for n in range(1, N+1):
        