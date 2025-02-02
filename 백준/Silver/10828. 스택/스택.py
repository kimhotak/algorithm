import sys

input = sys.stdin.read
commands = input().splitlines()

stack = []
for c in commands[1:]:
    if c == 'pop':
        print(stack.pop() if len(stack) > 0 else -1)

    elif c == 'size':
        print(len(stack))

    elif c == 'empty':
        print(1 if len(stack) == 0 else 0)
    
    elif c == 'top':
        print(stack[-1] if len(stack) > 0 else -1)
        
    else:
        x = c.split()[1]
        stack.append(x)