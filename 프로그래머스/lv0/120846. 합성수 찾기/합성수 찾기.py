def solution(n):
    # 합성수 체크
    def check(a):
        for i in range(2,int(a/2)+1):
            if not a%i:
                return 1
        return 0
    return sum([check(i) for i in range(1,n+1)])