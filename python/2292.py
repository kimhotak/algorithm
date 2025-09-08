n = int(input())
n -= 1
i = 1
while n > 0:
    n -= i*6
    i+=1
print(i)

# 1 6 12 18 24
# 1번집에 6의 배수