n = int(input())
s = input().strip()
print('Yes' if (n >= 3 and s[-3:] == 'tea') else 'No')