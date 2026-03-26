import re
def solution(myStr):
    answer = [i for i in re.split(r'[abc]+', myStr) if i]
    return answer if answer else ['EMPTY']