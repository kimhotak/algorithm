import sys
input = sys.stdin.readline

n, h = map(int, input().split())

area = [0] * (h + 2)
for i in range(n):
    size = int(input())
    if i&1: # 홀수 종유석
        area[-size-1] += 1
        area[-1] -= 1
    else: # 짝수 석순
        area[0] += 1
        area[size+1] -= 1

for i in range(1, h + 2):
    area[i] += area[i-1]

res = []
res.append(min(area[1:-1]))
res.append(area[1:-1].count(res[0]))

print(*res)