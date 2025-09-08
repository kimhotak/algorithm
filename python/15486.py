import sys
input = sys.stdin.readline
n = int(input())
time = []
pay = []
for i in range(n):
    t, p = map(int, input().split())
    time.append(t)
    pay.append(p)

pay[-1] = pay[-1] if time[-1] == 1 else 0

for i in range(n-2,-1,-1):
    if time[i] == 1:
        pay[i] = pay[i] + pay[i+1]

    elif i + time[i] < n:
        pay[i] = max(pay[i] + pay[i+time[i]], pay[i+1])

    elif i + time[i] == n:
        pay[i] = max(pay[i], pay[i+1])

    else: # i + time[i] > n
        pay[i] = pay[i+1]

print(pay[0])