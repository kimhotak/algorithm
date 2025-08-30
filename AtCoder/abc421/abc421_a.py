import sys
input = sys.stdin.readline

n = int(input())

room = [input().strip() for _ in range(n)]

x, y = input().split()

print('Yes' if room[int(x)-1] == y else 'No')