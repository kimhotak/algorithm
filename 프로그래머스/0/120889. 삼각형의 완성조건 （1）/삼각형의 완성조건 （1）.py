def solution(sides):
    sides.sort()
    answer = sides[0]+sides[1] <= sides[2]
    return answer+1