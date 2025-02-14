import sys
from collections import Counter
n, m = map(int, sys.stdin.readline().split())
words = Counter(i for i in sys.stdin.read().split('\n') if len(i)>=m)
result = sorted(words.items(), key=lambda x: (-x[1],-len(x[0]),x[0]))
print('\n'.join(i[0] for i in result))