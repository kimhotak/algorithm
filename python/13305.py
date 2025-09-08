import sys
input = sys.stdin.readline

n = int(input())
road = list(map(int,input().split()))
oil_cost = list(map(int,input().split()))
cost = 0
cheap_oil = float('inf')

for dist, oil in zip(road, oil_cost):
    if oil < cheap_oil:
        cheap_oil = oil
    cost += cheap_oil * dist
    
print(cost)