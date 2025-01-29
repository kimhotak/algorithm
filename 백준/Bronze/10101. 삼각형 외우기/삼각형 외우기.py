import sys

a,b,c = map(int, sys.stdin.readlines())
if a + b + c != 180:
    print('Error')
elif a == b == c == 60:
    print('Equilateral')
elif any((a == b, b == c, c == a)):
    print('Isosceles')
else:
    print('Scalene')