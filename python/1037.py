import sys
input = sys.stdin.readline
n = input()
a = tuple(map(int, input().split()))
print(max(a)*min(a))