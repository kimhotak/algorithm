def solution(str_list):
    for idx, item in enumerate(str_list):
        if item == 'l':
            return str_list[:idx]
        elif item == 'r':
            return str_list[idx+1:]
    return []