import sys
input = sys.stdin.readline

n, m = map(int,input().split())
adrs2pw = {}

for _ in range(n):
    adrs, pw = input().split()
    adrs2pw[adrs] = pw

for _ in range(m):
    print(adrs2pw[input().strip()])