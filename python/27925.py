import sys
import heapq

input = sys.stdin.readline

n = int(input())
foods = [i for i in map(int, input().split())]

# 다익스트라 개념으로 접근 (우선순위 큐 기반 최단 경로 탐색)
# hq에 들어가는 거는 (비용, 음식 인덱스, 인덕션 상태)
# 비용은 버튼 누른 수
# visited에 사용했던것 (음식 인덱스, 인덕션 상태)에 비용 저장
hq = []
heapq.heapify(hq)
heapq.heappush(hq, (0,-1,(0,0,0)))
visited = dict()

# 인덕션 상태는 정렬해 hq에 들어가는 것 최소화
# 맨 처음 0,0, (0,0,0) 넣음

def dist(x, y):
    return min((x-y)%10, (y-x)%10)

# hq 있을동안 계속 돌게
# hq 꺼내고 음식 인덱스 체크
# 꺼낸거 가지고 visited에 있는지 체크 비용이 더 높으면 해당 노드 버림
# visit에 추가
# 다음 음식 인덱스 자리에 있는 것으로 갈수 있는 것들 hq에 추가
while hq:
    cost, food_idx, inducts = heapq.heappop(hq)
    if food_idx == len(foods)-1:
        print(cost)
        break

    if (food_idx, inducts) in visited and visited[(food_idx, inducts)] <= cost:
        continue

    visited[(food_idx, inducts)] = cost
    new_food = foods[food_idx+1]

    for i in range(3):
        new_cost = dist(inducts[i], new_food) + cost
        new_ind = [v if j != i else new_food for j,v in enumerate(inducts)]
        new_ind = tuple(sorted(new_ind))
        heapq.heappush(hq,(new_cost, food_idx+1, new_ind))