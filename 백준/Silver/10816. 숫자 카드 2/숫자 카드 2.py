from collections import Counter
import sys
input = sys.stdin.readline
n = int(input())
card_cnt = Counter(map(int, input().split()))
m = int(input())
print(' '.join(str(card_cnt[i]) for i in map(int, input().split())))