import sys

m, n = map(int, sys.stdin.readline().split())
board = sys.stdin.read().split()

chess = [
    'WBWBWBWB',
    'BWBWBWBW',
    'WBWBWBWB',
    'BWBWBWBW',
    'WBWBWBWB',
    'BWBWBWBW',
    'WBWBWBWB',
    'BWBWBWBW',
    'WBWBWBWB']
result = 8*8
for i in range(m-7):
    for j in range(n-7):
        # result = min(result, )
        temp = [k[j:j+8] for k in board[i:i+8]]
        result = min(result,
            sum(not(c==d) for a,b in zip(temp, chess[:-1]) for c,d in zip(a,b)),
            sum(not(c==d) for a,b in zip(temp, chess[1:]) for c,d in zip(a,b))
        )
print(result)