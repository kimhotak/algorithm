def solution(n, s, a, b, fares):
    # 그래프 초기화
    graph = {}

    for u, v, w in fares:
        graph.setdefault(u, {})[v] = w
        graph.setdefault(v, {})[u] = w

    # 다익스트라 알고리즘
    def dijkstra(start):
        distances = {i: float('inf') for i in range(1, n + 1)}
        distances[start] = 0
        visited = set()

        while len(visited) < n:
            current_node = None
            current_dist = float('inf')

            # 방문하지 않은 노드 중 최단 거리 노드 선택
            for node in distances:
                if node not in visited and distances[node] < current_dist:
                    current_node = node
                    current_dist = distances[node]

            if current_node is None:
                break

            visited.add(current_node)

            for neighbor, weight in graph[current_node].items():
                new_dist = current_dist + weight
                if new_dist < distances[neighbor]:
                    distances[neighbor] = new_dist

        return distances

    # 최단 거리 계산
    dist_from_s = dijkstra(s)  # 출발점에서 모든 노드까지
    dist_from_a = dijkstra(a)  # a에서 모든 노드까지
    dist_from_b = dijkstra(b)  # b에서 모든 노드까지

    # 최소 비용 계산
    min_cost = float('inf')
    for k in range(1, n + 1):  # 합승 경로 고려
        cost = dist_from_s[k] + dist_from_a[k] + dist_from_b[k]
        min_cost = min(min_cost, cost)

    return min_cost
