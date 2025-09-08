import sys
import heapq
input = sys.stdin.readline

n = int(input())

big, small = [], []
# small은 - 해서 넣는다.
for n in range(1, n+1):
    a = int(input())
    if big and big[0] < a:
        heapq.heappush(big, a)
    else:
        heapq.heappush(small, -a)
        
    while len(small) > len(big) + 1:
        heapq.heappush(big, -heapq.heappop(small))

    while len(small) < len(big):
        heapq.heappush(small, -heapq.heappop(big))

    print(-small[0])