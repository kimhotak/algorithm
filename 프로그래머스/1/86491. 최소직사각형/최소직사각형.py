def solution(sizes):
    long_max, short_max = 0,0
    for w,h in sizes:
        if w < h:
            w,h = h,w
        long_max = max(w,long_max)
        short_max = max(h,short_max)
    return long_max*short_max