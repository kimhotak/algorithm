n, k = map(int, input().split())
m = list(range(1, n+1))
answer = []

idx = 0
while m:
    idx = (idx + k - 1) % len(m)
    answer.append(str(m.pop(idx)))

print(f'<{ ', '.join(answer) }>')