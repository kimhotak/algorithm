import math
def solution(my_str, n):
    answer = [my_str[i*n:i*n+n] for i in range(math.ceil(len(my_str)/n))]
    return answer