import sys
from collections import deque
input = sys.stdin.readline
t = int(input())
for _ in range(t):
    n, k = map(int, input().split())
    time = [0] + list(map(int, input().split()))

    graph = [[] for _ in range(n+1)]
    indegree = [0] * (n+1)

    for _ in range(k):
        x, y = map(int,input().split())
        graph[x].append(y)
        indegree[y] += 1

    dq = deque()
    acc_time = [0] * (n+1)

    for i in range(1, n+1):
        if indegree[i] == 0:
            dq.append(i)
            acc_time[i] = time[i]

    while dq:
        curr = dq.popleft()
        for next in graph[curr]:
            indegree[next] -= 1
            if indegree[next] == 0:
                dq.append(next)
            acc_time[next] = max(acc_time[next], acc_time[curr] + time[next])

    w = int(input())
    print(acc_time[w])