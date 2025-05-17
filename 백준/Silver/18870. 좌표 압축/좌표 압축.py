import sys

input = sys.stdin.readline

n = int(input())
nums = list(map(int,input().split()))

num_to_pack = {item:str(i) for i,item in enumerate(sorted(list(set(nums))))}

print(' '.join(num_to_pack[num] for num in nums))