import sys
from collections import deque
input = sys.stdin.readline
n, k = map(int,input().split())
belt = deque(map(int,input().split()))
robots = deque([False] * n)

answer = 0
while sum(1 for i in belt if i<1) < k:
    answer += 1
    belt.rotate()
    robots.rotate()
    robots[-1] = False

    for j in range(n-2,-1,-1):
        if (robots[j]) and (not robots[j+1]) and (belt[j+1] > 0):
            robots[j] = False
            robots[j+1] = True
            belt[j+1] -= 1
    robots[-1] = False

    if belt[0] > 0:
        robots[0] = True
        belt[0] -= 1
print(answer)