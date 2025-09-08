from collections import deque
import sys

input = sys.stdin.readline
d = deque()
n = int(input())
for _ in range(n):
    cmd = input().rstrip()
    if cmd.startswith(('1','2')):
        cmd, data = map(int,cmd.split())
    else:
        cmd = int(cmd)
    if cmd == 1:
        d.appendleft(data)
    elif cmd == 2:
        d.append(data)
    elif cmd == 3:
        print(d.popleft() if d else -1)
    elif cmd == 4:
        print(d.pop() if d else -1)
    elif cmd == 5:
        print(len(d))
    elif cmd == 6:
        print(0 if d else 1)
    elif cmd == 7:
        print(d[0] if d else -1)
    elif cmd == 8:
        print(d[-1] if d else -1)