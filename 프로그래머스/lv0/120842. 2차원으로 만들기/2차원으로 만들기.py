def solution(num_list, n):
    answer = [[]]
    return [[num_list[j+i] for j in range(n)] for i in range(0,len(num_list),n)]