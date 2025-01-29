import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    H, W, N = map(int,input().split())
    h = N%H
    w = (N-1)//H + 1
    print((str(h) if h != 0 else str(H))+ ('0' if w<10 else '') +str(w))