import sys
input = sys.stdin.readline
n, r, c = map(int,input().split())

num = 2**n
dr, dc = 0, 0
answer = 0

while num >= 1:
    num >>= 1
    block_num = 0

    if r >= num + dr:
        block_num |= 2
        dr += num
    if c >= num + dc :
        block_num |= 1
        dc += num
    
    answer += num * num * block_num
print(answer)