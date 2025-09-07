import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    a, b, c = map(int, input().split())

    # 어떻게 되었건 B 먼저 소진해야한다.
    res = min(a, b, c)
    a -= res
    c -= res

    # c가 항상 크도록 만든다.
    if a > c:
        a, c = c, a

    # 큰거 소진시키면서 개수를 같게 만들어본다?
    # a - x = c - 2 * x
    # x = c - a
    # c - a 개 만큼 소진하면 개수가 같아진다.
    x = min(c - a, a) # 소진할 개수
    res += x
    c -= 2 * x
    a -= x

    # 남아 있고 이후에 개수가 같은 상태
    if a > 0:
        res += (a+c)//3
    print(res)

