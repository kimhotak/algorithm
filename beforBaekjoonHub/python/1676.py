import math
n = str(math.factorial(int(input())))[::-1]
for i,v in enumerate(n):
    if v != '0':
        print(i)
        break