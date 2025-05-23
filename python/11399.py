import sys
input = sys.stdin.readline
n = int(input())
p = list(map(int,input().split()))
p.sort(reverse=True)
answer = 0
while p:
    answer += len(p) * p.pop()
print(answer)