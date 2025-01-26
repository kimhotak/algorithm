import sys
while '.' != (ps := sys.stdin.readline().rstrip()):
    stack = []
    for p in ps:
        if p in '([':
            stack.append(p)
        elif p == ')':
            if stack and stack[-1] == '(':
                stack.pop()
            else:
                print('no')
                break
        elif p == ']':
            if stack and stack[-1] == '[':
                stack.pop()
            else:
                print('no')
                break
    else:
        print('no' if stack else 'yes')