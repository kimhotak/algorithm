def solution(answers):
    # 1번: 12345
    # 2번: 2 섞어서 1345
    # 3번: 2번씩 31245
    a2 = (2,1,2,3,2,4,2,5)
    a3 = (3,3,1,1,2,2,4,4,5,5)
    o = [0]*3
    for i,a in enumerate(answers):
        if i%5+1 == a:
            o[0]+=1
        if a2[i%8] == a:
            o[1]+=1
        if a3[i%10] == a:
            o[2]+=1
            
    highest = max(o)
    return [idx+1 for idx,item in enumerate(o) if item == highest]