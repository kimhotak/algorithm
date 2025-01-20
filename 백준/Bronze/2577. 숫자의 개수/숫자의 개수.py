from collections import Counter
a = 1
for _ in range(3):
    a *= int(input())
b = Counter(str(a))
for i in range(10):
    print(b[str(i)])