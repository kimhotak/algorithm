def solution(numbers):
    # 소수판별
    number_set = set()
    numbers = list(numbers)
    def add_num(bfr_num, num):
        for i in range(len(num)):
            n = list(num)
            temp = bfr_num + n.pop(i)
            number_set.add(int(temp))
            add_num(temp ,n)
            
    add_num('',numbers)
    print(number_set)
    answer = len(number_set)
    for i in number_set:
        for j in range(2,int(i**(1/2))+1):
            if not i%j: # 나누었을 때 나머지가 0이면
                answer -=1
                break 
    if 0 in number_set:
        answer -=1
    if 1 in number_set:
        answer -=1
        
    return answer