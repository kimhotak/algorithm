def solution(n, arr1, arr2):
    answer = ['' for i in range(n)]
    for y in range(n):
        ar1 = bin(arr1[y])[2:].zfill(n)
        ar2 = bin(arr2[y])[2:].zfill(n)
        for x in range(n):
            if ar1[x] == '1' or ar2[x] == '1':
                answer[y] += '#'
            else:
                answer[y] += ' '
        
    return answer