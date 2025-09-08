import sys
from collections import Counter
input = sys.stdin.readline
n = int(input())
nums = [int(input()) for _ in range(n)]
print(round(sum(nums)/len(nums)))
nums.sort()
print(nums[len(nums)//2])
if len(nums)<2:
    print(nums[0])
else:
    cnt_nums = Counter(nums)
    m1,m2 = cnt_nums.most_common(2)
    print(m1[0] if m1[1]>m2[1] else m2[0])
print(nums[-1]-nums[0])