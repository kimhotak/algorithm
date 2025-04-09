def solution(myString, pat):
    pat = pat.replace('A','C').replace('B','A').replace('C','B')
    return int(pat in myString)