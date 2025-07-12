def solution(s):
    answer = [-1 for i in range(len(s))]
    idx = 0
    while idx < len(s):
        cnt = idx-1
        while cnt >= 0:
            if s[idx] == s[cnt]:
                answer[idx] = idx-cnt
                break
            cnt -=1
        idx += 1
    return answer