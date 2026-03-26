def solution(s):
    return ' '.join(''.join(j.lower() if i%2 else j.upper() for i,j in enumerate(w)) for w in s.split(' '))