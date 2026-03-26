import math
def solution(arr):
    result_len = 2 ** math.ceil(math.log2(len(arr)))
    return arr+[0 for i in range(result_len-len(arr))]