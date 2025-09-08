n = int(input())
# n은 짝수만 가능하다
if n%2:
    print(0)
    exit()
else:
    n //= 2

dp = [3] * n
for i in range(1,n):
    dp[i] = 3*dp[i-1]
    for j in range(i-1):
        dp[i] += 2*dp[j]
    dp[i] += 2
print(dp[-1])