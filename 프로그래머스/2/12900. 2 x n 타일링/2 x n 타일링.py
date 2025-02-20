def solution(n):
    a,b = 0,1
    for _ in range(n):
        b, a = a+b, b
    return b%1000000007