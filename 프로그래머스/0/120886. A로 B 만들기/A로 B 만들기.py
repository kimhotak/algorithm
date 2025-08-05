def solution(before, after):
    for i in set(before):
        if before.count(i) != after.count(i):
            return 0
    return 1