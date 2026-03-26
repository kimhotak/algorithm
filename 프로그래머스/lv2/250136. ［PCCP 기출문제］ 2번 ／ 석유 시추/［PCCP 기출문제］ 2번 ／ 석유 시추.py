from collections import deque

def solution(land):
    row = len(land) # row의 개수
    col = len(land[0]) # col의 개수
    answer = [0 for _ in range(col)]
    
    dr = (0,1,0,-1)
    dc = (1,0,-1,0)
    
    def bfs(r, c):
        land[r][c] = 0
        oil_amount = 1
        oil_points = set()
        oil_points.add(c)
        
        Q = deque()
        Q.append((r,c))
        
        while Q:
            r,c = Q.popleft()
            for i in range(4):
                nr = r + dr[i]
                nc = c + dc[i]
                if not(0 <= nr < row) or not(0 <= nc < col):
                    continue
                if land[nr][nc] == 0:
                    continue
                oil_amount += 1
                oil_points.add(nc)
                land[nr][nc] = 0
                Q.append((nr, nc))
        
        for point in oil_points:
            answer[point] += oil_amount
        return
    
    for r in range(row):
        for c in range(col):
            if land[r][c] == 1:
                bfs(r,c)
                
    return max(answer)


# 각 [r][c]별로 한번씩 순회하면서 bfs로 해당하는 지표면 좌표에 더해준다.