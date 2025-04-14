def solution(my_string, indices):
    indices.sort(reverse = True)
    my_string = list(my_string)
    for i in indices:
        my_string.pop(i)
    return ''.join(my_string)