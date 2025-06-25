isbn = [int(i) if i.isdigit() else None for i in input()]
m = int(isbn.pop())
lost_idx = isbn.index(None)
lost_m = 0
for idx, value in enumerate(isbn):
    if value == None:
        continue
    if idx % 2 == 0:
        lost_m += value
    else:
        lost_m += value * 3

lost_m = lost_m % 10
w = 3 if lost_idx % 2 else 1

for i in range(10):
    if (10 - (lost_m + w*i)) % 10 == m:
        print(i)
        break