import sys
input = sys.stdin.readline

x, c = map(int, input().split())

# 1000 당 c 의 수수료 수수료 다 떼고 숫료 못함 1000 엔단위

# 1000 * n + c * n < x
# (1000 + c) * n < x
# n < x/(1000 + c)

n = x // (1000 + c)
print(1000 * n)