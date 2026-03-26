import math

def solution(left, right):
    answer = (left+right)*(right-left+1)/2
    for i in range(math.ceil(left**(1/2)),math.floor(right**(1/2))+1):
        answer -= 2*i**2
    return answer