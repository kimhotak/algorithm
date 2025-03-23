def solution(numbers):
    list = [0,0]
    for i in numbers:
        list.append(i)
        list.sort(reverse=True)
        list.pop()
    answer = list[0]*list[1]
    return answer