import sys
from collections import deque
import heapq
input = sys.stdin.readline

n, k = map(int, input().split())

group = deque(list(map(int, input().split())) for _ in range(n))

time = 0
cnt = 0
enterd = []
while group:
    # 그룹 도착
    a, b, c = group.popleft()

    # 도착 시간으로 조정
    while enterd and enterd[0][0] <= a:
        _, tmp = heapq.heappop(enterd)
        cnt -= tmp

    # 바로 입장가능
    if cnt + c <= k:
        time = max(time, a)

    # 앞팀 나올 때 까지 대기
    while cnt + c > k:
        endTime, num = heapq.heappop(enterd)
        time = endTime
        cnt -= num

    # 입장 절차
    print(time)
    heapq.heappush(enterd, (time + b, c))
    cnt += c