N = int(input())
ROW = 1 << 10
COL = 10
LIMIT = 1_000_000_000
dp = [[0] * ROW for _ in range(COL)]

for i in range(1, COL):
    dp[i][1 << i] = 1

for i in range(1, N):
    new_dp = [[0] * ROW for _ in range(COL)]
    for j in range(COL):
        for k in range(ROW):
            
            if dp[j][k] == 0:
                continue

            if dp[j][k] >= LIMIT:
                dp[j][k] %= LIMIT

            if j+1 < COL:
                new_dp[j+1][k | (1 << (j+1))] += dp[j][k]
            if j-1 >= 0:
                new_dp[j-1][k | (1 << (j-1))] += dp[j][k]
    dp = new_dp

ans = 0
for i in range(COL):
    ans += dp[i][ROW-1]
    ans %= LIMIT
print(ans)


# 1. 0부터 9까지 숫자가 모두 등장
# 2. 계단수
# 3. 0으로 시작하면 계단수 X

# 행을 2^10 로 써서 1번 조건 만족 (비트 마스크)

# 열은 마지막 숫자
# n이 증가하며 마지막 숫자에서 하나씩만 움직여 2번 조건 만족

# 비트가 1개만 켜져있으면 1로 시작 3번조건 만족

# n (= 문자열의 길이 수)을 늘려가며 탐색