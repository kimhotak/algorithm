def solution(n):
    answer = to3(n)
    return answer

def to3(a: int) -> str: 
    result = ''
    if a < 3:
        return str(a)
    while a:
        if a%3 == 0:
            result = '4' + result
            a = (a-1)//3
        else:
            result = str(a%3) + result
            a //= 3
    return result