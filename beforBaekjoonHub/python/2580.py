import sys
input = sys.stdin.readline

board = [list(map(int, input().split())) for _ in range(9)]
zeros = [(i, j) for i in range(9) for j in range(9) if board[i][j] == 0]

def is_valid(y, x, n):
    for i in range(9):
        if board[y][i] == n or board[i][x] == n:
            return False
    sy, sx = 3 * (y // 3), 3 * (x // 3)
    for i in range(3):
        for j in range(3):
            if board[sy + i][sx + j] == n:
                return False
    return True

def dfs(idx):
    if idx == len(zeros):
        for b in board:
            print(' '.join(map(str, b)))
        exit()
    y, x = zeros[idx]
    for i in range(1,10):
        if is_valid(y, x, i):
            board[y][x] = i
            dfs(idx + 1)
            board[y][x] = 0

dfs(0)
