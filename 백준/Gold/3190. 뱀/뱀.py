from collections import deque
import sys

input = sys.stdin.readline

n = int(input())
k = int(input())

apples = set()
for _ in range(k):
    apples.add(tuple(map(int,input().split())))

l = int(input())
cmd = deque()
for _ in range(l):
    cmd.append(sys.stdin.readline().split())

move = ((0,1),(1,0),(0,-1),(-1,0),) # 인덱스 늘리면 D 줄이면 L
v = 0

snake = deque()
snake.append((1,1))

time = 0

while True:
    time += 1
    next_step = tuple(s+m for s,m in zip(snake[0],move[v]))
    if next_step in snake or any(s<1 or s>n for s in next_step):
        print(time)
        break

    snake.appendleft(next_step)
    if next_step in apples:
        apples.remove(next_step)
    else :
        snake.pop()

    if cmd and int(cmd[0][0]) == time:
        v = (v + (1 if cmd[0][1] == 'D' else - 1)) % 4
        cmd.popleft()
