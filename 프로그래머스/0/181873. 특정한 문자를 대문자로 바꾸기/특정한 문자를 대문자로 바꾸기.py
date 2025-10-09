def solution(my_string, alp):
    answer = ""
    for i in my_string:
        if i == alp:
            i = i.upper()
        answer += i
    return answer