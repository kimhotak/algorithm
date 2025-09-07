import sys
input = sys.stdin.readline
w,s = map(int,input().split('-'))
w = (s + 1)//9 + w
s = (s + 1) % 9
print(f'{w}-{1 if s == 0 else s}')