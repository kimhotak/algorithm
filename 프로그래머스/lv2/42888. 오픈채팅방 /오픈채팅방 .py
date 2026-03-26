def solution(record):
    record = [r.split(' ') for r in record]
    
    user_dic = {}
    for i in record:
        if not i[0] == 'Leave':
            user_dic[i[1]] = i[2]
        
    answer = []
    for i in record:
        if i[0] == 'Enter':
            answer.append(f'{user_dic[i[1]]}님이 들어왔습니다.')
        elif i[0] == 'Leave':
            answer.append(f'{user_dic[i[1]]}님이 나갔습니다.')
    return answer