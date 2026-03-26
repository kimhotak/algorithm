def solution(myString):
    answer = ''.join([i.upper() if i=='a' else i for i in myString.lower()])
    return answer