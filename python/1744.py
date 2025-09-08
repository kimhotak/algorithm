import sys
input = sys.stdin.readline

n = int(input())
a ,b, c, d = [], [], [], []
for _ in range(n):
    i = int(input())
    if i < 0:
        a.append(i)
    elif i == 0:
        b.append(i)
    elif i == 1:
        c.append(i)
    elif i > 1:
        d.append(i)
a.sort()
d.sort(reverse=True)
answer = sum(c)
for i in range(1,len(a),2):
    answer += a[i]*a[i-1]
if len(a)%2 and not b:
    answer += a[-1]


for i in range(1,len(d),2):
    answer += d[i]*d[i-1]
if len(d)%2:
    answer += d[-1]

print(answer)
# a < 0 작은 수 부터 묶어줘야함
# a = 0 - 가 홀수면 하나 묶고 안묶어야 함
# a = 1 안 묶어야 함
# a > 1 큰 수 부터 묶어야함