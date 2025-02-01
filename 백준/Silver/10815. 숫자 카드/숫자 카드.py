import sys
input = sys.stdin.readline
n = input()
cards = set(map(int,input().split()))
m = input()
print(' '.join('1' if i in cards else '0' for i in map(int,input().split())))