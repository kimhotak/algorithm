import sys
from collections import defaultdict
input = sys.stdin.readline
t = int(input())
for _ in range(t):
    wear = defaultdict(set)
    n = int(input())
    for _ in range(n):
        name, part = input().split()
        wear[part].add(name)
    kind = 1
    for k in wear.keys():
        kind *= len(wear[k]) + 1
    print(kind - 1)