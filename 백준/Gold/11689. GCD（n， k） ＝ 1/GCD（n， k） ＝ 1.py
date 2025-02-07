n = int(input())

if n == 1:
    print(1)
    exit()

result = n
i = 2
while i * i <= n:
    if n % i == 0:
        while n % i == 0:
            n //= i
        result -= result // i
    i += 1
if n > 1:
    result -= result // n
print(result)