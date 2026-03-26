def solution(s):
    for num,word in enumerate(('zero','one','two','three','four','five','six','seven','eight','nine')):
        s = s.replace(word,str(num))
    answer = int(''.join(s))
    return answer
