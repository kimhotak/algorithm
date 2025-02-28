def solution(n):
    # a까지 1씩 커졌을 때 합
    # (a+1)*a/2 = n
    # 2n = a**2+a
    # k부터 1씩 b번 커졌을 때 합. # b는 0일수 있다.
    # (2k+b)(b+1)/2 = n
    # k = (2n-b**2-b)/(2b+2)
    
    a = 1
    n2 = 2*n
    while n2 > a**2+a:
        a+=1
    answer = 0
    for b in range(a):
        k = (n2-b**2-b)/(2*b+2)
        if k == int(k):
            answer +=1
    return answer