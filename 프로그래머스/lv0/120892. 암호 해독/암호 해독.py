def solution(cipher, code):
    answer = ''.join([cipher[i] for i in range(code-1,len(cipher),code)])
    return answer