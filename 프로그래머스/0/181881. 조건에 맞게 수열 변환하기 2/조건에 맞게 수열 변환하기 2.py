def solution(arr):
    answer = 0
    for i in set(arr):
        a = 0
        while(i>=50 and not i%2) or (i<50 and i%2):
            if i>=50:
                i/=2
            else:
                i=i*2+1
            a+=1
        if a > answer:
            answer = a
    return answer