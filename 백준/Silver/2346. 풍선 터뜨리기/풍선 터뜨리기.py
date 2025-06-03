import sys
from collections import deque
input = sys.stdin.readline
n = int(input())
balloons = deque((idx+1, int(item))for idx,item in enumerate(input().split()))
pop = []
while balloons:
    num, paper = balloons.popleft()
    pop.append(str(num))
    balloons.rotate(-paper+(paper>0))
print(' '.join(pop))