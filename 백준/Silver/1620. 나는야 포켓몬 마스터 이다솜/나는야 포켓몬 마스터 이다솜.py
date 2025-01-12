import sys
input = sys.stdin.readline
n, m = map(int, input().split())
poketmon = {i:input().strip() for i in range(1,n+1)}
for i in range(1,n+1):
    poketmon[poketmon[i]] = i

for _ in range(m):
    quiz = input().strip()
    if quiz.isdigit():
        quiz = int(quiz)
    print(poketmon[quiz])