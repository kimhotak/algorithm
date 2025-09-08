import sys
input = sys.stdin.readline

while True:
    num = input().strip()
    if num == '0':
        break
    f, b = 0, len(num)-1
    while f < b:
        if num[f] != num[b]:
            print('no')
            break
        f += 1
        b -= 1
    else:
        print('yes')