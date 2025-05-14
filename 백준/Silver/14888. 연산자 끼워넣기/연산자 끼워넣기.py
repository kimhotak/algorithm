import sys
input = sys.stdin.readline

n = int(input())
A = list(map(int,input().split()))
op = list(map(int,input().split()))

op_dict = {0:'+', 1:'-', 2:'*', 3:'//'}
max_val = -float('inf')
min_val = float('inf')

def push_op(value, cnt):
    global max_val, min_val
    if cnt == n:
        max_val = max(max_val, value)
        min_val = min(min_val, value)
        return
    for i in range(4):
        if op[i]:
            op[i] -= 1

            if i == 0:
                next_val = value + A[cnt]
            elif i == 1:
                next_val = value - A[cnt]
            elif i == 2:
                next_val = value * A[cnt]
            elif i == 3:
                if value < 0:
                    next_val = -(-value // A[cnt])
                else:
                    next_val = value // A[cnt]

            push_op(next_val, cnt + 1)
            op[i] += 1

push_op(A[0], 1)
print(max_val)
print(min_val)