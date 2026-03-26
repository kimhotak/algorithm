def solution(a, b):
    answer = 0
    return sum([i for i in range(min(a,b),max(a,b)+1)])