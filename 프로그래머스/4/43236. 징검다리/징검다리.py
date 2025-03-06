def solution(distance, rocks, n):
    rocks = sorted(rocks) + [distance]
    bot, top = 0,distance
    rmvd = []
    while top >= bot:
        mid = (bot+top)//2
        rm_cnt = 0
        bfr_dist = 0
        for r in rocks:
            if r-bfr_dist < mid:
                rm_cnt+=1
            else:
                bfr_dist=r
        if rm_cnt > n:
            top = mid-1
        else:
            rmvd.append(mid)
            bot = mid+1
    return max(rmvd)