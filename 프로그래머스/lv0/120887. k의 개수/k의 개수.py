def solution(i, j, k):
    answer = 0
    return sum(str(i).count(str(k)) for i in range(i,j+1))