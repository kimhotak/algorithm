def solution(array):
    answer = ''.join(str(i) for i in array).count('7')
    return answer