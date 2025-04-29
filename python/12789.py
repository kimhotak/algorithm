import sys
from collections import deque

input = sys.stdin.readline
n = int(input())
line = deque(map(int, input().split()))
sub_line = []
for i in range(1,n+1):
    if sub_line and i == sub_line[-1]:
        sub_line.pop()
        
    else:
        while line and line[0] != i:
            sub_line.append(line.popleft())

        if line:
            line.popleft()
        else:
            print('Sad')
            break
else:
    print('Nice')
    