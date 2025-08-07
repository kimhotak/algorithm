import sys
input = sys.stdin.readline
n = int(input())
people = [-1] + list(map(int, input().split()))
edge = [tuple(map(int, input().split())) for _ in range(n - 1)]
# edge가 인접한 마을의 번호로 나온다
# edge를 dp의 한 축으로 삼으면 될듯

dp = [0 for _ in range(n)]
# edge가 0번 인덱스부터 i개 있을때로 dp

visited = set()
# 이미 edge로 연결된 마을

print(people)
print(edge)