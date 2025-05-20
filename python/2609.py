import math
a, b = map(int,input().split())
c = math.gcd(a,b)
print(f'{c}\n{a*b//c}')