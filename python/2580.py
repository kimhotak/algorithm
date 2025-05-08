import sys

input = sys.stdin.readline

table = [list(map(int, input().split())) for _ in range(9)]

# dfs
# 0의 위치를 잡는다.
Y, X = [], []
for i in range(9):
    for j in range(9):
        if table[i][j] == 0:
            Y.append(i)
            X.append(j)

# 0의 위치에 들어갈 수 있는 숫자들을 Z에 기록
Z = []
for y,x in zip(Y,X):
    able = set(i for i in range(10))
    able -= set(table[y])
    able -= set(table[i][x] for i in range(9))
    able -= set(table[(y//3)*3+j][(x//3)*3+i] for i in range(3) for j in range(3))
    Z.append(list(able))

stack = [[]]
while stack:
    path = stack.pop()
    if len(path) == len(Z):
        Z = path
        break
    for next_node in Z[len(path)]:
        if 
        stack.append(path + [next_node])
else: