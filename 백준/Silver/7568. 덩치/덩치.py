import sys
input = sys.stdin.readline
n = int(input())
A = []
for i in range(n):
    A.append(list(map(int,input().split())))
# 자신보다 더 큰 덩치의 사람이 k명이라면 그 사람의 덩치 등수는 k+1이 된다
for i in range(n):
    k = 1
    for j in range(n):
        if A[i][0] < A[j][0] and A[i][1] < A[j][1]:
            k += 1
    print(k,end=' ')