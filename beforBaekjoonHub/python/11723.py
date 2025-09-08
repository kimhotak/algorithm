import sys
input = sys.stdin.readline
m = int(input())
s = set()
for _ in range(m):
    cmd = input().split()
    if len(cmd) == 2:
        x = int(cmd.pop())
    cmd = cmd[0]
    if cmd == 'add':
        s.add(x)
    elif cmd == 'remove':
        if x in s:
            s.remove(x)
    elif cmd == 'check':
        print(int(x in s))
    elif cmd == 'toggle':
        s.remove(x) if x in s else s.add(x)
    elif cmd == 'all':
        s = set(i for i in range(1,21))
    elif cmd == 'empty':
        s = set()