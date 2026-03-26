def solution(array, n):
    answer = 0
    closest = 100
    for i in array:
        diff = abs(n-i)
        if diff < closest:
            closest = diff
            answer = i
        elif diff == closest and i < answer:
            closest = diff
            answer = i
    return answer