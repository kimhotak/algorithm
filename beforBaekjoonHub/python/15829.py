import sys
input = sys.stdin.readline
l = int(input())
S = input().strip()
print(sum((ord(s)-96)*31**i for i,s in enumerate(S))%1234567891)