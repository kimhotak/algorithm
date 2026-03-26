def solution(str_list, ex):
    answer = ''.join([i for i in str_list if not ex in i])
    return answer