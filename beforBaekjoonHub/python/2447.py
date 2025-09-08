import sys

n = int(sys.stdin.readline())
star = [['*']*n for _ in range(n)]

def punch_star(n, row, col):
    if n <= 1:
        return
    m = n//3
    for i in range(0, n, m):
        for j in range(0, n, m):
            if i==j==m:
                for k in range(i,i+m):
                    for l in range(j,j+m):
                        star[row+k][col+l] = ' '
            else:
                punch_star(m,row+i,col+j)

punch_star(n,0,0)
print('\n'.join(''.join(i) for i in star))