import sys

input = sys.stdin.readline
n = int(input())
stack = []
for _ in range(n):
    cmd = input()

    if cmd.startswith('2'):
        if stack:
            print(stack.pop())
        else:
            print(-1)

    elif cmd.startswith('3'):
        print(len(stack))

    elif cmd.startswith('4'):
        print(int(not bool(stack)))

    elif cmd.startswith('5'):
        if stack:
            print(stack[-1])
        else:
            print(-1)

    else:# cmd.startswith('1')
        cmd = cmd.split()[1]
        stack.append(cmd)
