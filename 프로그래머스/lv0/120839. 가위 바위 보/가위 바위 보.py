def solution(rsp):
    answer = rsp.replace('0','1').replace('2','0').replace('5','2').replace('1','5')
    return answer