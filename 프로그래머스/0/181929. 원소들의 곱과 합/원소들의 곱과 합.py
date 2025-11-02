def solution(num_list):
    s, x = 0, 1
    for i in num_list:
        s+=i
        x*=i
    return int(x<s**2)