def solution(s):
    answer = [0,0]
    while s != '1':
        cnt1 = s.count('1')
        answer[1] += len(s)-cnt1
        answer[0] += 1
        s = bin(cnt1)[2:]
    return answer