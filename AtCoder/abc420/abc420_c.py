import sys
input = sys.stdin.readline

n, q = map(int, input().split())

a = list(map(int, input().split()))
b = list(map(int, input().split()))

res = sum(min(a[i], b[i]) for i in range(n))
for i in range(q):
    c, x, v = input().split()
    x, v = int(x)-1, int(v)

    tmp = min(a[x], b[x])
    if c == 'A':
        a[x] = v
    else: # c == 'B'
        b[x] = v
    
    if tmp != min(a[x], b[x]):
        res -= tmp - min(a[x],b[x])

    print(res)