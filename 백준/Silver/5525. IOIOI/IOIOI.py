import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
s = input()

idx = 0
answer = 0
while idx < m:
    if s[idx] == 'I':
        cnt = 0
        idx += 1
        while idx < m and s[idx:idx+2] == 'OI':
            cnt += 1
            idx += 2
        answer += max(0, cnt-n+1)
    else:
        idx += 1

print(answer)