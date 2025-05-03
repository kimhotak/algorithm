import sys

n = int(sys.stdin.readline())
result = 0

col = [1] * n
diag1 = [1] * (2*n)
diag2 = [1] * (2*n)

def n_queen(row):
    global result
    if row == n:
        result += 1
        return
    
    for i in range(n):
        if col[i] and diag1[row+i] and diag2[row-i+n]:
            col[i] = diag1[row+i] = diag2[row-i+n] = 0
            n_queen(row + 1)
            col[i] = diag1[row+i] = diag2[row-i+n] = 1

n_queen(0)
print(result)
