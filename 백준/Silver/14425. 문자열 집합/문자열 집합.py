import sys
input = sys.stdin.readline
n, m = map(int, input().split())
s = set(input() for _ in range(n))
print(sum(i in s for i in (input() for _ in range(m))))