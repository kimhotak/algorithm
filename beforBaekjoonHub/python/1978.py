import math
import sys
input = sys.stdin.readline

n = int(input())
nums = map(int, input().split())
cnt = 0
for i in nums:
    if i == 1:
        cnt +=1
    for j in range(2, i//2+1):
        if i%j == 0:
            cnt += 1
            break
print(n-cnt)