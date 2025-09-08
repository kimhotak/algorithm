x = int(input())

i = 1
while (i*(i+1))//2 < x:
    i += 1

k = x - (i*(i-1))//2

if i%2 == 0:
    top = k
    bot = i-k+1
else:
    top = i-k+1
    bot = k

print(f"{top}/{bot}")
