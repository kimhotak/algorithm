def solution(brown, yellow):
    # brown - 4 를 하면 yellow의 둘레가 나온다.
    # (brown - 4)/2는 yellow의 가로+세로
    wh = (brown-4)//2
    for b in range(wh+1):
        if b*(wh-b) == yellow:
            return [wh-b+2,b+2]
    answer = []
    return answer