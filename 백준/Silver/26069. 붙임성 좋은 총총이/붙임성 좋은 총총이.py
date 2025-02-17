import sys
input = sys.stdin.readline

rainbow_dancing = set()
rainbow_dancing.add('ChongChong')
n = int(input())
for _ in range(n):
    a,b = input().split(' ')
    b = b.rstrip()
    if a in rainbow_dancing:
        rainbow_dancing.add(b)
    elif b in rainbow_dancing:
        rainbow_dancing.add(a)
print(len(rainbow_dancing))