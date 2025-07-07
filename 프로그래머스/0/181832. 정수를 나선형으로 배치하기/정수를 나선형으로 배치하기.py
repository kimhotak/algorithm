def solution(n):
    answer = [[0] * n for _ in range(n)]
    directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    x, y = 0, 0
    direction = 0
    for k in range(1, n * n + 1):
        answer[x][y] = k
        nx, ny = x + directions[direction][0], y + directions[direction][1]
        if nx < 0 or nx >= n or ny < 0 or ny >= n or answer[nx][ny] != 0:
            direction = (direction + 1) % 4
            nx, ny = x + directions[direction][0], y + directions[direction][1]
        x, y = nx, ny
    
    return answer
