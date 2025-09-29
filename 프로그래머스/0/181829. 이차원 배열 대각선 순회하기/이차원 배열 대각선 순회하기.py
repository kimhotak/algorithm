def solution(board, k):
    answer = 0
    return sum([sum([board[i][j] for j in range(len(board[i])) if i+j<=k]) for i in range(len(board))])