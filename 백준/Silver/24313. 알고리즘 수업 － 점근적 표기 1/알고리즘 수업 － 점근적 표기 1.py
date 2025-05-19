a1, a2 = map(int,input().split())
c = int(input())
n = int(input())
if c < a1 or a1*n+a2 > c*n:
    print(0)
else:
    print(1)