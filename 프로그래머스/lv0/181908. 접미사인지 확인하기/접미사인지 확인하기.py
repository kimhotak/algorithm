def solution(my_string, is_suffix):
    return int(my_string[::-1].startswith(is_suffix[::-1]))