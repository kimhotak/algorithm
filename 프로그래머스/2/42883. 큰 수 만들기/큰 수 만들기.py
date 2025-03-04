def solution(number, k):
    answer = ''
    high = []
    for i in range(0,len(number)):
        while k > 0 and high and number[i] > high[-1]:
            high.pop(-1)
            k -= 1
        high.append(number[i])
        
    if k > 0:
        high = high[:-k]
    return ''.join(high)