import sys
input = sys.stdin.readline

n = int(input())
row = []
col = []

for _ in range(n):
    tmp = input().split()
    row.append(int(tmp[0]))
    col.append(int(tmp[1]))

row_min, row_max = min(row), max(row)
col_min, col_max = min(col), max(col)

avg_row = (row_min + row_max) // 2
avg_col = (col_min + col_max) // 2

print(max(avg_row - row_min,
          row_max - avg_row,
          avg_col - col_min,
          col_max - avg_col,
          ))