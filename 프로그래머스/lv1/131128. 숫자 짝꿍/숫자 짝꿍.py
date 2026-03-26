def solution(X, Y):
    find_list_X = [0 for i in range(10)]
    find_list_Y = [0 for i in range(10)]
    for i in X:
        find_list_X[int(i)] += 1
    for i in Y:
        find_list_Y[int(i)] += 1
    
    answer = ''
    for i in range(9,0,-1):
        if not find_list_Y[i]== 0 and not find_list_X[i] == 0:
            if find_list_Y[i] > find_list_X[i]:
                answer += str(i)*find_list_X[i]
            else :
                answer += str(i)*find_list_Y[i]

    if answer:
        if find_list_X[0] and find_list_Y[0]:
            if find_list_Y[0] > find_list_X[0]:
                answer += '0'*find_list_X[0]
            else :
                answer += '0'*find_list_Y[0]   
    else:
        if find_list_X[0] and find_list_Y[0]:
            return '0'
        else:
            return '-1'
    
    return answer