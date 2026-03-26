import itertools

def solution(number):
    answer = 0
    for a,b,c in itertools.combinations(range(len(number)),3):
        if 0 == number[a] + number[b] + number[c]:
            answer+=1
    return answer