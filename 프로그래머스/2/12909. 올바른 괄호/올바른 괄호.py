def solution(s):
    in_cnt = 0
    for i in s:
        if i == '(':
            in_cnt += 1
        elif i == ')':
            if in_cnt == 0:
                return False
            in_cnt -= 1
    return in_cnt == 0