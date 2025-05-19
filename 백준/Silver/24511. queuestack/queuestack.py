import sys
input = sys.stdin.readline
n = input()
A = input().split()
B = input().split()

b = [b for a,b in zip(A,B) if a=='0']
b.reverse()
m = int(input())
b += input().split()

print(' '.join(b[:m]))