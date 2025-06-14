import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    ps = input().strip()
    cnt = 0
    for s in ps:
        if s == '(':
            cnt +=1
        else: # s == ')'
            if cnt:
                cnt -=1
            else:
                print('NO')
                break
    else:
        print('NO' if cnt else 'YES')