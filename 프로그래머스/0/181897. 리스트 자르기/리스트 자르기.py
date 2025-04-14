def solution(n, slicer, num_list):
    a,b,c = slicer
    b+=1
    if n == 1:
        answer = num_list[:b]
    elif n == 2:
        answer = num_list[a:]
    elif n == 3:
        answer = num_list[a:b]
    elif n == 4:
        answer = num_list[a:b:c]
    return answer