import sys
input = sys.stdin.readline
n = int(input())
A = [int(input()) for _ in range(n)]
A.reverse()
stack = []
answer = ''
for i in range(1,n+1):
    stack.append(i)
    answer += '+'

    while stack and A and stack[-1] == A[-1]:
        stack.pop()
        A.pop()
        answer += '-'

print('NO' if stack or A else '\n'.join(answer))