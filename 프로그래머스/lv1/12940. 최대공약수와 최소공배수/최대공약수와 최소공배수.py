def solution(n, m):
    answer = [None,n*m]
    while n != 0:
        m, n = n, m%n
    answer[0] = m
    answer[1] = answer[1]/m
    return answer