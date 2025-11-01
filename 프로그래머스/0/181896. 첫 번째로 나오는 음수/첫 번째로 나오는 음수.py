def solution(num_list):
    for idx, item in enumerate(num_list):
        if item < 0:
            return idx
    return -1