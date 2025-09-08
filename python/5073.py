import sys
def triangle(n):

    n.sort()
    if n[2] >= n[0]+n[1]:
        return 'Invalid'
    
    s = set(n)
    if len(s) == 1:
        return 'Equilateral'
    elif len(s) == 2:
        return 'Isosceles'
    else:
        return 'Scalene'

while True:
    n = list(map(int,sys.stdin.readline().split()))
    if n[0] == 0:
        break
    print(triangle(n))
