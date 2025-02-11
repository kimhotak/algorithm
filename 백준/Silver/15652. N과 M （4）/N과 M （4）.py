import sys

n, m = map(int,sys.stdin.readline().split())
def backtrack(start, path):
    if len(path) == m:
        print(' '.join(map(str,path)))
        return
    for i in range(start, n+1):
        backtrack(i, path+[i])
backtrack(1,[])