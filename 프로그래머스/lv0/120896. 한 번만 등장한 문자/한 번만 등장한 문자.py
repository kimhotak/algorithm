def solution(s):
    answer = ''.join(sorted(i for i in set(s) if s.count(i)==1))
    return answer