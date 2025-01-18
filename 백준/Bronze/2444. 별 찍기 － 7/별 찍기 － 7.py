n = int(input())

for i in range(n):
    print(f'{' '*(n-i-1)}{'*'*(i+1)}{'*'*(i)}')
for i in range(n-2,-1,-1):
    print(f'{' '*(n-i-1)}{'*'*(i+1)}{'*'*(i)}')