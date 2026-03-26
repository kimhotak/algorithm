def solution(my_string):
    answer = ''
    used = set()
    for i in my_string:
        if not i in used:
            answer += i
            used.add(i)
    return answer