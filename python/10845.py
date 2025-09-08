from collections import deque
import sys
input = sys.stdin.readline

Q = deque()
t = int(input())

for _ in range(t):
    order = input().strip().split()
    if order[0] == 'pop':
        print(Q.popleft() if Q else -1)
    elif order[0] == 'size':
        print(len(Q))
    elif order[0] == 'empty':
        print(0 if Q else 1)
    elif order[0] == 'front':
        print(Q[0] if Q else -1)
    elif order[0] == 'back':
        print(Q[-1] if Q else -1)
    else:
        Q.append(order[1])