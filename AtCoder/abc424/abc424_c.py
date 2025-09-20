import sys
input = sys.stdin.readline

n = int(input())
skill = [list() for _ in range(n+1)]
for i in range(1, n+1):
    a, b = map(int, input().split())
    skill[a].append(i)
    skill[b].append(i)

learned = set()
stack = [0]

while stack:
    cur = stack.pop()
    for next in skill[cur]:
        if next in learned:
            continue
        stack.append(next)
        learned.add(next)

print(len(learned))