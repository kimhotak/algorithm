from collections import Counter
import sys
input = sys.stdin.readline
n = input()
card_cnt = Counter(map(int, input().split()))
m = input()
print(*(card_cnt[i] for i in map(int, input().split())))