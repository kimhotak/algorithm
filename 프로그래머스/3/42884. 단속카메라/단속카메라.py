def solution(routes):
    # 정렬해서 최대한 뒤에 넣고 안들어가는 것 부터 다시 맨 뒤에 놓는다?
    answer = 0
    routes.sort(key= lambda x:x[1])
    print(routes)
    
    # 마지막 카메라의 지점
    cam = -30001
    
    for i,o in routes:
        if i > cam:
            # 카메라를 최대한 뒤인 진출지점에 놓는다.
            cam = o 
            answer += 1
            
    return answer