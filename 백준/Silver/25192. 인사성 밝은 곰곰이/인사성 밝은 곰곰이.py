import sys
input = sys.stdin.readline
n = int(input())
result = 0
gomgom = set()
for _ in range(n):
    log = input().strip()
    if log == 'ENTER':
        result += len(gomgom)
        gomgom.clear()
    else:
        gomgom.add(log)
result += len(gomgom)
print(result)