def solution(myString):
    answer = ''.join('l' if i<'l' else i for i in myString)
    return answer