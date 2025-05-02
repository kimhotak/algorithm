import sys
import heapq
from collections import defaultdict
input = sys.stdin.readline

class DPQ:
    max_hq = None
    min_hq =  None
    both_have = None
    length = None
    def __init__(self):
        self.max_hq = []
        self.min_hq = []
        self.both_have = defaultdict(int)
        self.length = 0
        return
    
    def append(self, num):
        heapq.heappush(self.max_hq, -num)
        heapq.heappush(self.min_hq, num)
        self.both_have[num] += 1
        self.length += 1
        return
    
    def max_pop(self):
        if self.length == 0:
            self.__init__()
            return None
        tmp = -heapq.heappop(self.max_hq)
        while self.max_hq and self.both_have[tmp] < 1:
            tmp = -heapq.heappop(self.max_hq)
        self.both_have[tmp] -= 1
        self.length -= 1
        return tmp
    
    def min_pop(self):
        if self.length == 0:
            self.__init__()
            return None
        tmp = heapq.heappop(self.min_hq)
        while self.min_hq and self.both_have[tmp] < 1:
            tmp = heapq.heappop(self.min_hq)
        self.both_have[tmp] -= 1
        self.length -= 1
        return tmp

t = int(input())
for _ in range(t):
    k = int(input())
    dpq = DPQ()
    
    for _ in range(k):
        cmd, n = input().split()
        n = int(n)
        if cmd == 'I':
            # 값 입력
            dpq.append(n)
        else:
            if n == 1 and dpq:
                # 최댓값 삭제
                dpq.max_pop()
            elif dpq:
                # 최솟값 삭제
                dpq.min_pop()

    if dpq.length == 1:
        tmp = dpq.max_pop()
        print(tmp, tmp)
    elif dpq.length > 1:
        print(dpq.max_pop(), dpq.min_pop())
    else:
        print('EMPTY')

# 만약 힙큐가 2개라면, 양쪽에서 삭제를 못한다.
# 그렇다면 한쪽에서 삭제 했는데 반대쪽에서 삭제 안된것을 어떻게 검출할까
# 사전으로 만들어서 아닌 것을 검출한다?