import sys
from collections import deque
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    k = int(input())
    dpq = []
    
    for _ in range(k):
        cmd, n = input().split()
        n = int(n)
        if cmd == 'I':
            # 값 입력
            dpq.append(n)
            dpq.sort()
        else:
            if n == 1 and dpq:
                # 최댓값 삭제
                dpq.pop()
            elif dpq:
                # 최솟값 삭제
                dpq = dpq[1:]

    if dpq:
        print(dpq[-1], dpq[0])
    else:
        print('EMPTY')