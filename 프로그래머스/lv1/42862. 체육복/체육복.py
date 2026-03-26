def solution(n, lost, reserve):
    for l in lost[:]:
        if l in reserve:
            reserve.remove(l)
            lost.remove(l)
    
    lost.sort()
    reserve.sort()
    
    l,r = 0,0
    answer = 0
    while len(lost) > l and len(reserve) > r:
        if lost[l] + 1 == reserve[r] or lost[l] == reserve[r] + 1:
            l+=1
            r+=1
        elif lost[l] > reserve[r]:
            r+=1
        else:
            l+=1
            answer+=1
    
    if len(lost) > l:
        answer += len(lost) - l
    
    return n-answer