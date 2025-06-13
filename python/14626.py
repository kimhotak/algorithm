isbn = list(input())
m = int(isbn.pop())
lost_m = 0
lost_idx = None
for i in range(12):
    if isbn[i] == '*':
        lost_idx = i
    else:
        lost_m += int(isbn[i]) * (3 if i%2 else 1)
lost_m %= 10
# lost_idx의 값에 따라 다름
if lost_idx % 2:
    # *3한값
    # lost_m + 3 * X = m
    print((m - lost_m) // 3)
else:
    answer = m - lost_m
    print(answer + (10 if answer < 0 else 0))