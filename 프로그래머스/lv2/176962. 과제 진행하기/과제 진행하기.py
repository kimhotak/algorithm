def solution(plans):
    plans.sort(key = lambda x:x[1], reverse=True)
    for i,p in enumerate(plans):
        plans[i][1] = int(p[1].split(':')[0])*60+int(p[1].split(':')[1])
        plans[i][2] = int(plans[i][2])
        
    keep = [] # stack처럼 사용해서 append와 pop만 사용
    answer = []
    
    while len(plans):
        p = plans.pop()
        if not len(plans): # 다음 plan이 없을 경우 plan 실행후 keep 순서대로 
            answer.append(p[0])
            for i in keep[::-1]:
                    answer.append(i[0])
            break
        if p[1]+p[2] > plans[-1][1]: # 시작시간+소요시간 다음시작시간보다 클 때
            # 차이만큼 소요시간을 줄이고 keep에 저장
            p[2] -= plans[-1][1] - p[1]
            keep.append(p)
            
        else:# 시작시간+소요시간 다음시작시간보다 같거나 작을 때
            # answer에 plans[0]저장
            answer.append(p[0])
            if p[1]+p[2] < plans[-1][1] and len(keep):# 시작시간+소요시간 다음 시작시간보다 작을 때 keep이 있다면
                # 시작시간+소요시간을 keep의 시작 작업에 집어넣고 plans에 append
                keep[-1][1] = p[1]+p[2]
                plans.append(keep.pop())
    return answer