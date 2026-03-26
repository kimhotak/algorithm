def solution(n):
    # 3진법의 자릿수 찾기
    len3 = 0 # 3진법 자릿수
    while n//(3**len3) != 0:
        len3+=1
    print(len3)
        
    # 3진법 표기 리스트로 변경
    n_3 = [(n%(3**(i+1)))//(3**i) for i in range(len3-1,-1,-1)]
    print(n_3)
    
    # 3진법을 반전 안하고 자릿수 계산으로 10진법으로 변환
    answer = sum(item*(3**idx)for idx,item in enumerate(n_3))
    
    return answer