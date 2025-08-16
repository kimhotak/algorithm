import sys
input = sys.stdin.readline

s = input().strip()

res = ''
if s == 'red':
    res = 'SSS'
elif s == 'blue':
    res = 'FFF'
elif s == 'green':
    res = 'MMM'
else:
    res = 'Unknown'
print(res)