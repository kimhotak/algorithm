import sys
input = sys.stdin.readline

n = int(input())
S, W = [], []
for _ in range(n):
    s, w = map(int, input().split())
    S.append(s)
    W.append(w)

max_broken = 0

def dfs(pick):
    global max_broken
    if pick == n:
        broken = sum(s <= 0 for s in S)
        max_broken = max(max_broken, broken)
        return

    if S[pick] <= 0:
        dfs(pick + 1)
        return

    hit_any = False
    for i in range(n):
        if i == pick or S[i] <= 0:
            continue
        hit_any = True
        # 계란 치기
        S[i] -= W[pick]
        S[pick] -= W[i]
        dfs(pick + 1)
        # 원상 복구
        S[i] += W[pick]
        S[pick] += W[i]

    if not hit_any:
        dfs(pick + 1)

dfs(0)
print(max_broken)
