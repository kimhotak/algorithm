def solution(d, budget):
    for idx,item in enumerate(sorted(d)):
        budget -= item
        if budget < 0:
            return idx
    return len(d)