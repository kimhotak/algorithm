import sys
input = sys.stdin.readline

x, y = map(int, input().split())

def f(n: int):
    return int(str(n)[::-1])

for i in range(3,11):
    tmp = y
    y = f(x + y)
    x = tmp

print(y)