def solution(angle):
    if angle == 180:
        a = 4
    elif angle > 90:
        a = 3
    elif angle == 90:
        a = 2
    else:
        a = 1
    return a