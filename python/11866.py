from collections import deque
import sys

n, k = map(int, sys.stdin.readline().split())

table = deque(i for i in range(1,n+1))

yosefut = []
while table:
    table.rotate(-k)
    yosefut.append(table.pop())

print(f'<{', '.join(map(str,yosefut))}>')