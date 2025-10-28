def solution(strArr):
    answer = [item.lower() if idx%2==0 else item.upper() for idx, item in enumerate(strArr)]
    return answer