import sys
input = sys.stdin.readline
l, c = map(int, input().split())
char = sorted(list(input().split()))

res = []
def dfs(idx):
    if len(res) == l:
        cnt = 0
        for r in res:
            if r in 'aeiou':
                cnt += 1
        if cnt >= 1 and l-cnt >= 2:
            print(''.join(res))
        return
    elif idx >= c:
        return
    
    for i in range(idx, c):
        res.append(char[i])
        dfs(i + 1)
        res.pop()
dfs(0)
