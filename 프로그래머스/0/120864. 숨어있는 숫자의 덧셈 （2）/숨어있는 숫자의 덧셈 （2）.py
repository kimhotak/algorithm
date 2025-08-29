def solution(my_string):
    answer = ''.join(i if i.isdigit() else ' ' for i in my_string).split()
    return sum(int(i) for i in answer if i)