def solution(n):
    answer = [[1 if j ==i else 0 for j in range(n)]for i in range(n)]
    return answer