import sys
input = sys.stdin.readline
n = int(input())
tower = list((i,j) for i, j in enumerate(map(int,input().split())))
laser = []
answer = [0] * n
while tower:
    while laser and laser[-1][1] <= tower[-1][1]:
        answer[laser[-1][0]] = tower[-1][0] + 1
        laser.pop()
    laser.append(tower.pop())

print(' '.join(map(str,answer)))