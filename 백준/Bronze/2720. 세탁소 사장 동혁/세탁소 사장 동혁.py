import sys

t = list(map(int,sys.stdin.readlines()[1:]))

coin = [25, 10, 5, 1]

for i in t:
    result = []
    for c in coin:
        result.append(str(i//c))
        i = i%c
    print(' '.join(result))