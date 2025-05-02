import sys
input = sys.stdin.readline
n = int(input())
company = set()
for _ in range(n):
    name, log = input().split()
    if log == 'enter':
        company.add(name)
    else:
        company.discard(name)
print('\n'.join(sorted(list(company),reverse=True)))