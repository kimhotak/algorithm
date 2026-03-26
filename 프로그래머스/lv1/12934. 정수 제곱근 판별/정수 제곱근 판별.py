def solution(n):
    x = n**0.5
    return (x+1)**2 if not x%1 else -1