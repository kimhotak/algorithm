import sys

m, n = map(int, sys.stdin.readline().split())
board = sys.stdin.read().split()

result = 8*8
for i in range(m-7):
    for j in range(n-7):
        w_cnt = 0 # 좌측 위 w
        b_cnt = 0 # 좌측 위 B
        for x in range(8):
            for y in range(8):
                if (x+y)%2 == 0:
                    if board[i+x][j+y] == 'B':
                        w_cnt +=1
                    else:
                        b_cnt +=1
                else:
                    if board[i+x][j+y] == 'B':
                        b_cnt +=1
                    else:
                        w_cnt +=1
        result = min(result, w_cnt, b_cnt)
print(result)