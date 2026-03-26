def solution(arr1, arr2):
    if len(arr1)>len(arr2):
        return 1
    if len(arr2)>len(arr1):
        return -1
    ar1s = sum(arr1)
    ar2s = sum(arr2)
    if ar1s == ar2s:
        return 0
    return (ar1s>ar2s)*2-1