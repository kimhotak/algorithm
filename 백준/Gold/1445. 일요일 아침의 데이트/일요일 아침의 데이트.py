import sys
import heapq
input = sys.stdin.readline

# 입력 처리 0-index
n, m = map(int,input().split())
forest = []
flower = None
start = None
for i in range(n):
    tmp = list(input().strip())
    if 'F' in tmp:
        flower = (i,tmp.index('F'))
    if 'S' in tmp:
        start = (i,tmp.index('S'))
    forest.append(tmp)

# 상 하 좌 우
dy = (1, 0, -1, 0)
dx = (0, 1, 0, -1)

# 맵 조작 쓰레기=>2, 근처=>1, else=>0
for y in range(n):
    for x in range(m):
        tmp = forest[y][x]
        if tmp == '.' or tmp == 'S' or tmp == 'F':
            forest[y][x] = 0

        elif tmp == 'g':
            forest[y][x] = 2

            for i in range(4):
                ny = y + dy[i]
                nx = x + dx[i]
                if not (0 <= ny < n and 0 <= nx < m):
                    continue
                if forest[ny][nx] == 2 or forest[ny][nx] == 'g':
                    continue
                forest[ny][nx] = 1

# heapq에 들어갈것
# (지나간 쓰레기수, 근처로 지나간 쓰레기 수, 해당 노드)
hq = []
heapq.heappush(hq,(0,0,start))
visited = set()
visited.add(start)

while hq:
    Gbg, gbg, (y,x) = heapq.heappop(hq)
    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]

        if not (0 <= ny < n and 0 <= nx < m):
            continue
        if (ny,nx) in visited:
            continue
        nGbg, ngbg = Gbg, gbg
        if forest[ny][nx] == 1:
            ngbg += 1
        elif forest[ny][nx] == 2:
            nGbg += 1

        if (ny,nx) == flower:
            print(f'{Gbg} {gbg}')
            exit()

        visited.add((ny, nx))
        heapq.heappush(hq,(nGbg, ngbg, (ny, nx)))


# 결국 근처로 하나도 안가거나 안지나가 거나 한 가능한 것들을 해보아야 안 할수 있다.
# bfs로 풀어도 될듯 근데 heapq 에 우선순위를 쓰레기 지나가는것과 근처 지나가는것 포함해서