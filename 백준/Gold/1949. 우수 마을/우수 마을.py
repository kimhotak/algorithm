import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)  # 재귀 한도 증가

n = int(input())
people = [-1] + list(map(int, input().split()))
edge = [[] for _ in range(n + 1)]

for _ in range(n-1):
    v1, v2 = map(int, input().split())
    edge[v1].append(v2)
    edge[v2].append(v1)

dp = [[0,0] for _ in range(n + 1)]
visited = [False] * (n + 1)

def dfs(node):
    visited[node] = True
    dp[node][1] = people[node]  # 현재 노드를 우수마을로 선택
    
    for next_node in edge[node]:
        if visited[next_node]:
            continue
        dfs(next_node)
        dp[node][0] += max(dp[next_node][0], dp[next_node][1])  # 현재 노드를 선택하지 않으면 자식은 선택/비선택 가능
        dp[node][1] += dp[next_node][0]  # 현재 노드를 선택하면 자식은 선택 불가

dfs(1)
print(max(dp[1][0], dp[1][1]))