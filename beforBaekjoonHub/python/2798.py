import sys
from itertools import combinations

n, m = map(int, sys.stdin.readline().split())
card = list(map(int, sys.stdin.readline().split()))

print(max(sum(i) for i in combinations(card,3) if sum(i) <= m))