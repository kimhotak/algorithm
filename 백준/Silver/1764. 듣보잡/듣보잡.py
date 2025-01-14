import sys
input = sys.stdin.readline
n, m = map(int,input().split())
hear = {input().strip() for _ in range(n)}
see = {input().strip() for _ in range(m)}
hear_see = sorted(list(hear & see))
print(f'{len(hear_see)}\n{'\n'.join(hear_see)}')