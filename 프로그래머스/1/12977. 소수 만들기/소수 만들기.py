def solution(nums):
    answer = 0
    idx = 0
    while idx < len(nums)-2:
        idx1 = idx+1
        while idx1 < len(nums)-1:
            idx2 = idx1+1
            while idx2 < len(nums):
                if is_sosu(nums[idx]+nums[idx1]+nums[idx2]):
                    answer+=1
                idx2 +=1
            idx1 +=1
        idx +=1
    return answer

def is_sosu(n):
    i = 2
    while i <= n**(1/2):
        if n%i == 0:
            return False
        i += 1
    return True
        