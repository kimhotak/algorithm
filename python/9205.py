import sys
input = sys.stdin.readline
t = int(input())

for _ in range(t):
    n = int(input())
    home = tuple(map(int,input().split()))
    store = [tuple(map(int,input().split())) for _ in range(n)]
    party = tuple(map(int,input().split()))
    print(home, store, party)
    