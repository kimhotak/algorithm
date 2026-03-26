def solution(ineq, eq, n, m):
    answer = 0
    return int(eval(str(n)+ineq+eq+str(m)if eq == '=' else str(n)+ineq+str(m)))