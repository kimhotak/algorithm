import sys
from collections import defaultdict

num = defaultdict(int)
n = int(sys.stdin.readline())
for i in range(n):
    num[int(sys.stdin.readline())] +=1
    
for i in sorted(num.keys()):
    for _ in range(num[i]):
        print(i)