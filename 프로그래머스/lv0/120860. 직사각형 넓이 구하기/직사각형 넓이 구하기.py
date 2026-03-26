def solution(dots):
    dots = list(map(list,zip(*dots)))
    return (max(dots[0])-min(dots[0]))*(max(dots[1])-min(dots[1]))