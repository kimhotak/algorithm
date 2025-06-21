num, base = map(int,input().split())

digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
result = ''
while num > 0:
    result = digits[num % base] + result
    num //= base
    
print(result)