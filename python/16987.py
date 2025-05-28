import sys
input = sys.stdin.readline

n = int(input())
S, W = [], []
for _ in range(n):
    s, w = map(int, input())
    S.append(s)
    W.append(w)

pick = 0
def dfs(pick, state):
    if 
# 뎁스가 최대 900000*4