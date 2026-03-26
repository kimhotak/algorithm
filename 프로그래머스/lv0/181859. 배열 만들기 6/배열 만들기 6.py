def solution(arr):
    stk = []
    i = 0
    while i < len(arr):
        if stk:
            if stk[-1] == arr[i]:
                stk.pop()
            else:
                stk.append(arr[i])
            i+=1
        else:
            stk.append(arr[i])
            i+=1
    return stk if stk else [-1]