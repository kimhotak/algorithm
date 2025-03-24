def solution(n):
    a = set()
    while n!=1:
        for i in range(2,n+1):
            if n%i == 0:
                a.add(i)
                n//=i
                break
    return sorted(list(a))