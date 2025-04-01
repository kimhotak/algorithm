def solution(food):
    answer = ''
    for i,j in enumerate(food):
        answer += str(i)*int(j/2)
    answer += '0' + answer[::-1]
    return answer