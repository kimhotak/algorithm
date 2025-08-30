import sys
input = sys.stdin.readline

n = int(input())
s = input().strip()

# 결국엔 A로 시작하거나
# B로 시작하거나

# 결국에는 이동하는 거리
ai = [i for i,v in enumerate(s) if v == 'A']
ab = 0
ba = 0

for i in range(n):
    # 0부터 n까지
    ab += abs(ai[i] - (2 * i))
    ba += abs(ai[i] - (2 * i + 1))

print(min(ab, ba))