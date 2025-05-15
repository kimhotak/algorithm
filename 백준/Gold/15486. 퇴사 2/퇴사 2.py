import sys
input = sys.stdin.readline
n = int(input())
time = []
pay = []
for i in range(n):
    t, p = map(int, input().split())
    time.append(t)
    pay.append(p)

answer = [None] * n
answer[-1] = pay[-1] if time[-1] == 1 else 0

for i in range(n-2,-1,-1):
    if time[i] == 1:
        answer[i] = pay[i] + answer[i+1]

    elif i + time[i] < n:
        answer[i] = max(pay[i] + answer[i+time[i]], answer[i+1])

    elif i + time[i] == n:
        answer[i] = max(pay[i], answer[i+1])

    else: # i + time[i] > n
        answer[i] = answer[i+1]

print(answer[0])