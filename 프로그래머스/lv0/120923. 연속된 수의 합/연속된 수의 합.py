def solution(num, total):
    # 리스트의 시작 좌표
    start_value = total/num-(num-1)/2
    # 리스트 시작 좌표에서 1씩 더하기
    answer = []
    for i in range(0,num):
        answer.append(start_value+i)
    return answer