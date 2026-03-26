def solution(s):
    mid = int(len(s)/2)
    answer = ''
    if len(s)%2:
        answer = s[mid]
    else:
        answer = s[mid-1:mid+1]
    return answer