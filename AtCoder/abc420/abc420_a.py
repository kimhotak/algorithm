import sys
input = sys.stdin.readline

x, y = map(int,input().split())
res = (x + y)%12
print(12 if res == 0 else res)