import sys
input = sys.stdin.readline

for _ in range(int(input())):
    k = int(input())
    n = int(input())
    apt = [i for i in range(1,n+1)]
    for i in range(k):
        for j in range(n-1,0,-1):
            apt[j] = sum(apt[:j+1])
    print(apt[-1])