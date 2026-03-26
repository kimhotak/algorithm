def solution(arr):
    row, col = len(arr), len(arr[0])
    if row < col:
        arr+=[[0]*col for i in range(col-row)]
    elif row > col:
        for i in range(row):
            arr[i]+=([0]*(row-col))
    return arr