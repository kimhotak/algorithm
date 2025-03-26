def solution(my_string):
    answer = ''.join([i.lower() if i.isupper() else i.upper() for i in my_string ])
    return answer