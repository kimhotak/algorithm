def solution(arr, queries):
    answer = []
    for i,(s,e,k) in enumerate(queries):
        maxQ = 1000000
        flag = False
        for j in range(s,e+1):
            if arr[j]>k and arr[j] < maxQ:
                maxQ = arr[j]
                flag = True
        answer.append(maxQ if flag else -1)
    return answer