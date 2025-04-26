import sys
code = list(map(int,sys.stdin.readline().split()))
if code == list(i for i in range(1,9)):
    print('ascending')
elif code == list(i for i in range(8,0,-1)):
    print('descending')
else:
    print('mixed')