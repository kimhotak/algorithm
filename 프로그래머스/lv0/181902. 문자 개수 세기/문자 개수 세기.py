def solution(my_string):
    answer = [0 for i in range(52)]
    for i in my_string:
        answer[ord(i)-(ord('a')+26 if i.islower() else ord('A'))] += 1
    return answer