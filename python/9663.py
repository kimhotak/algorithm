import sys

n = int(sys.stdin.readline())
result = 0

down = [1] * n
ld = [1] * (2*n)
rd = [1] * (2*n)

def Nqueen(row=0):
    global result
    if row == n:
        result+=1
        return
    for col in range(n):
        if down[col] and ld[row+col] and rd[col-row+n]:
            down[col] = ld[row+col] = rd[col-row+n] = 0
            Nqueen(row+1)
            down[col] = ld[row+col] = rd[col-row+n] = 1
Nqueen()
print(result)