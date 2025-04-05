def solution(a, b):
    if (a+b)%2 == 1:
        return 2*(a+b)
    if a%2 == 1:
        return (a+b)**2-2*a*b
    return abs(a-b)