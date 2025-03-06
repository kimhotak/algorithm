def solution(n, computers):
    answer = 0
    def dfs(graph, start, visited=None):
        if visited is None:
            visited = set()
        visited.add(start)
        for idx,item in enumerate(graph[start]):
            if idx not in visited and item:
                dfs(graph, idx, visited)
        return visited
    
    linked = set(i for i in range(n))
    while linked:
        linked -= dfs(computers, linked.pop())
        answer += 1
    
    return answer