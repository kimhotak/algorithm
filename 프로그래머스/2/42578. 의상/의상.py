def solution(clothes):
    answer = 1
    c_by_type = {i[1]:1 for i in clothes}
    for name, c_type in clothes:
        c_by_type[c_type]+=1
    for i in c_by_type.values():
        answer *= i
    return answer-1