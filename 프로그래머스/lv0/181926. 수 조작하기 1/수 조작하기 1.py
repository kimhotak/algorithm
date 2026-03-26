def solution(n, control):
    input_dict = {'w':1, 's':-1, 'd':10, 'a': -10}
    answer = n + sum(input_dict[i] for i in control)
    return answer