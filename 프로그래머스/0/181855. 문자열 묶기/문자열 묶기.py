def solution(strArr):
    len_dict = {}
    for i in strArr:
        len_dict[len(i)] =  len_dict.get(len(i),0) + 1
    return max(len_dict.values())