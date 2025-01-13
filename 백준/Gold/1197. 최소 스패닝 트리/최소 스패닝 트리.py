import sys
input = sys.stdin.readline
# 최소 스패닝 트리는 정점의 개수 -1 개의 간선으로 연결된다.
# 간선들의 합이 가장 작으면 된다.
# 간선 기준으로 작은것부터 넣고, 연결되어있는 정점들끼리 잇는것들을 제외한다.

# 시간복잡도 고려
# 간선의 정렬에서 가장 오랜 시간이 걸릴것으로 예측된다.
# 파이썬은 1초에 10^7(천만, 10,000,000)번 계산 가능하다고 고려한다.
# 정렬알고리즘을 nlogn 쓰니까 100,000 *107 log 10 
# 가능하다.
v, e = map(int, input().split())

graph = []
# 가중치, 노드1, 노드2로 구성
for _ in range(e):
    graph.append(list(map(int, input().split()[::-1])))
graph.sort()

linked = {i:{i,} for i in range(1,v+1)}
# dict 안에 set으로 저장
cost_sum = 0

for cost, node1, node2 in graph:
    if node2 in linked[node1]:
        # 이미 연결되어있는 경우
        continue
    else:
        # 연결 안된 경우
        # 서로 연결 셋을 최신화 해주어야함
        cost_sum += cost
        if len(linked[node1]) < len(linked[node2]):
            node1, node2 = node2, node1
            
        linked[node1] |= linked[node2]

        for item in linked[node2]:
            linked[item] = linked[node1]
    if len(linked[1]) == v:
        break

print(cost_sum)