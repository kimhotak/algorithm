def solution(n):
    i, j = 1, 0
    while i <= n:
        j+=1
        i*=j
    return j-1