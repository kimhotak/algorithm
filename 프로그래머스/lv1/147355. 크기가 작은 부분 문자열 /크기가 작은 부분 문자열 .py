def solution(t, p):
    answer = 0
    cnt = 0
    while cnt+len(p) <= len(t):
        if t[cnt:cnt+len(p)] <= p:
            answer += 1
        cnt += 1
    return answer