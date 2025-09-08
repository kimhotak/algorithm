n = int(input())
result = 0
for i in range(1,n):
    if i + sum(int(i) for i in str(i)) == n:
        result = i
        break
print(result)