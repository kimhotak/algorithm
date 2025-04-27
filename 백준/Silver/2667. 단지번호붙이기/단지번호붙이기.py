import sys

input = sys.stdin.readline

n = int(input())
m = [list(input().strip()) for _ in range(n)]

house_cnt = []
i, ii = 0,0

def house_counting(y, x):
    tmp = 0
    m[y][x] = '0'
    for dy, dx in ((1,0), (-1,0), (0,1), (0,-1)):
        my, mx = y+dy, x+dx
        if (0 <= my < n)  and (0 <= mx < n)  and m[my][mx] == '1':
            tmp += house_counting(my, mx)
    return tmp + 1

while i < n:
    if m[i][ii] == '1':
        house_cnt.append(house_counting(i, ii))
    if ii+1 == n:
        i += 1
        ii = 0
    else :
        ii += 1

house_cnt.sort()
print(len(house_cnt))
print('\n'.join(map(str, house_cnt)))