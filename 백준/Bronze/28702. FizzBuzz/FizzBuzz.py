import sys
input = sys.stdin.readline
n = None
for i in range(3,0,-1):
    n = input().strip()
    if n.isdigit():
        n = int(n)+i
        break
output = ''
if n%3 == 0:
    output = 'Fizz'
if n%5 == 0:
    output += 'Buzz'
print(output if output else n)