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
# gpt에서 set 개수로 처리하는 방법도 추천해줌