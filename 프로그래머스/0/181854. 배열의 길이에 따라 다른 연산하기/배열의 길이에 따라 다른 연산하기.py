def solution(arr, n):
    isodd = bool(len(arr)%2)
    answer = []
    for idx,item in enumerate(arr):
        if isodd and idx%2==0:
            item += n
        elif not isodd and idx%2 !=0:
            item +=n
        answer.append(item)
    return answer