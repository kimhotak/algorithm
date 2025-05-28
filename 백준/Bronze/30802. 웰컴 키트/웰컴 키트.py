import sys
input = sys.stdin.readline
n = int(input())
tsize = list(map(int,input().split()))
t, p = map(int, input().split())
print(sum((i-1)//t+1 for i in tsize))
print(f'{n//p} {n%p}')