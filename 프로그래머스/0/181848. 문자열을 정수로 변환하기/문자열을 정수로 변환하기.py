def solution(n_str):
    answer = 0
    for idx, item in enumerate(n_str[::-1]):
        answer += (10**idx)*int(item)
    return answer 