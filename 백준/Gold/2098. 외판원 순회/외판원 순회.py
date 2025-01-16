import sys
input = sys.stdin.readline
n = int(input())
cost = [list(map(int, input().split())) for _ in range(n)]

dp = [[float('inf')] * (1 << n) for _ in range(n)]
dp[0][1 << 0] = 0
stack = []
stack.append((0,1 << 0))

while stack:
    befor_city, visited = stack.pop()
    for next_city in range(n):
        if visited & (1 << next_city):
            continue
        if cost[befor_city][next_city] == 0:
            continue

        to_visit = visited | (1 << next_city)
        update_cost = dp[befor_city][visited] + cost[befor_city][next_city]
        if dp[next_city][to_visit] <= update_cost:
            continue

        dp[next_city][to_visit] = update_cost
        stack.append((next_city, to_visit))

visited_all = (1 << n) - 1
ans = float('inf')
for last_city in range(n):
    if cost[last_city][0] == 0:
        continue
    ans = min(ans, dp[last_city][visited_all] + cost[last_city][0])

print(ans)