import sys
input = sys.stdin.readline
k = int(input())
nums = []
for _ in range(k):
    num = int(input())
    if num:
        nums.append(num)
    else:
        nums.pop()
print(sum(nums))