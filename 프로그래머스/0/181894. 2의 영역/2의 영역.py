def solution(arr):
    if not 2 in arr:
        return [-1]
    s,e = 0, -1
    for idx,item in enumerate(arr):
        if item == 2:
            s = idx
            break
    for idx,item in enumerate(reversed(arr)):
        if item == 2:
            e = -idx
            if e == 0:
                e = None
            break
    return arr[s:e]