def solution(order):
    return sum([not int(i)%3 and i!='0' for i in str(order)])