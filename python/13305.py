import sys
input = sys.stdin.readline

n = int(input())
# 도시 간 길의 거리
road = [int(input()) for _ in range(n-1)]
oil = [int(input()) for _ in range(n)]
cost = 0
cheap_oil = oil[0]

