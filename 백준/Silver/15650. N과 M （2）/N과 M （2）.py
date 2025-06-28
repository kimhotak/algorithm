import sys

n, m = map(int, sys.stdin.readline().split())
def backtrack(path, start):
    if len(path) == m:
        print(' '.join(map(str,path)))
        return
    for i in range(start,n+1):
        backtrack(path+[i], i+1)

backtrack([],1)