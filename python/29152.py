import sys
input = sys.stdin.readline

n = int(input())
factory = [list(map(int, list(input().strip()))) for _ in range(n)]

# 0행을 나타내는 dp 배열
dp = [0] + [float('inf') for _ in range(n-1)]
for row in range(n):

    machine = [col for col in range(n) if factory[row][col] == 1]
    left_machine = machine[0] if machine else float('inf')
    right_machine = machine[-1] if machine else -1

    prefix = [float('inf')] * n # 좌 -> 우
    suffix = [float('inf')] * n # 우 -> 좌
    # inf로 써서 그냥 더해버려도 됨

    # 좌 -> 우
    for col in range(n):
        if col == 0:
            prefix[col] = dp[col] + 1
        elif col <= left_machine:
            prefix[col] = min(dp[col], prefix[col - 1]) + 1
        else:
            prefix[col] = prefix[col - 1] + 1

    # 우 -> 좌
    for col in range(n-1, -1, -1):
        if col == n - 1:
            suffix[col] = dp[col] + 1
        elif col >= right_machine:
            suffix[col] = min(dp[col], suffix[col + 1]) + 1
        else:
            suffix[col] = suffix[col + 1] + 1
    
    for col in range(n):
        if col >= right_machine and col <= left_machine:
            dp[col] = min(prefix[col], suffix[col])
        elif col >= right_machine:
            dp[col] = prefix[col]
        elif col <= left_machine:
           dp[col] = suffix[col]
        else:
            dp[col] = float('inf')

print(dp[-1] if dp[-1] != float('inf') else -1)
