n=int(input())
result = 5000
for i in range(n//5+1):
    if (n-5*i)%3 == 0:
        result = min(result, i+((n-5*i)//3))
print(-1 if result==5000 else result)