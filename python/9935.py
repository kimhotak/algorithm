import sys
input = sys.stdin.readline
normal = list(input().strip())
normal.reverse()

bomb = list(input().strip())
len_bomb = len(bomb)

stack = []
while normal:
    stack.append(normal.pop())
    while stack[-len_bomb:] == bomb:
        # 슬라이싱은 자동 범위 조정
        del stack[-len_bomb:]

print(''.join(stack) if len(stack) else 'FRULA')