from collections import defaultdict
import heapq

def solution(N, road, K):
    answer = 0
    graph = defaultdict(list)
    for s,e,d in road:
        graph[s].append((e,d))
        graph[e].append((s,d))
    pq = []
    heapq.heappush(pq, (0,1))
    distances = {i+1:float('inf') for i in range(N)}
    distances[1] = 0
    while pq:
        current_dist, current_node = heapq.heappop(pq)
        if current_dist>distances[current_node]:
            continue
        for neighber, weight in graph[current_node]:
            if current_dist+weight < distances[neighber]:
                distances[neighber] = current_dist+weight
                heapq.heappush(pq,(current_dist+weight, neighber))
    for i in distances.values():
        if i<=K:
            answer +=1
    return answer