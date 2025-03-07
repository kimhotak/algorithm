def solution(n, times):
    times.sort()
    left,right = 0, 1000000000*1000000000 #시간에 대한 이분탐색
    possible_time = []
    
    while right > left:
        mid = (right+left)//2
        if sum(mid//t for t in times) < n:
            left = mid + 1
        else:
            right = mid
            possible_time.append(mid)
            
    return min(possible_time)