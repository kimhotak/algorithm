import sys, math
input = sys.stdin.readline
a,b = map(int, input().split())
c,d = map(int, input().split())
top = a*d+c*b
bot = b*d
m = math.gcd(top,bot)
print(top//m, bot//m)