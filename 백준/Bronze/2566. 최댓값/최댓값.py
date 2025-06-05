import sys

data = map(int,sys.stdin.read().split())
idx_max, item_max = 0, 0
for idx, item in enumerate(data):
    if item > item_max:
        item_max = item
        idx_max = idx
print(item_max)
print(idx_max//9+1, idx_max%9+1)