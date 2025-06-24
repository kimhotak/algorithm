import sys
from collections import deque

input = sys.stdin.readline
n = int(input())
line = deque(map(int, input().split()))
sub_line = []
for i in range(1,n+1):
    if i in sub_line:
        if i == sub_line[-1]:
            sub_line.pop()
        else:
            print('Sad')
            break
    else:
        while line[0] != i:
            sub_line.append(line.popleft())
        line.popleft()
else:
    print('Nice')
    