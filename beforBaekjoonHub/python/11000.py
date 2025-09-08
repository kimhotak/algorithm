import sys
import heapq
input = sys.stdin.readline

n = int(input())
time_table = []
for _ in range(n):
    time_table.append(tuple(map(int,input().split())))
time_table.sort(reverse=True)

room = []
heapq.heapify(room)

while time_table:
    clas = time_table.pop()
    if room and room[0] <= clas[0]:
        heapq.heappushpop(room, clas[1])
    else:
        heapq.heappush(room, clas[1])

print(len(room))

# 1 접근
# 그리디, 정렬하고 넣는다.
# 시간초과

# 2 접근
# 어디서 시간복잡도가 가장 높을까
# 끝나는 시간을 일일히 확인하는게 가장 높다
# 극단적이면 O(n^2)
# 최솟값만 체크하면 된다. heap 적용

# 3 접근 time_table도 heqp으로 하면?
# 기존 sort() O(nlogn) pop() O(1)
# 변경 heapify() O(n) heappop() O(logn)*n
# 같다