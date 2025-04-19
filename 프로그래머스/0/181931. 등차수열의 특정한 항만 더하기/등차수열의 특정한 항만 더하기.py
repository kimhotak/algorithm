def solution(a, d, included):
    return sum([a+d*idx for idx, item in enumerate(included) if item])