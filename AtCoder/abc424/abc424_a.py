import sys
input = sys.stdin.readline

a = set(input().split())

if len(a) <= 2:
    print("Yes")
else:
    print("No")