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
lost_m = 10 - (lost_m % 10)


answer = lost_m - m
if lost_idx%2:
    while answer%3 != 0:
        answer += 10
    print(answer // 3)
    pass
else:
    print(answer + (0 if answer > 0 else 10) )