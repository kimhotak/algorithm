def solution(wallpaper):
    answer = [len(wallpaper),len(wallpaper[0]),0,0]
    for xidx,x in enumerate(wallpaper):
        for yidx,y in enumerate(x):
            if y == '#':
                answer[0] = min(answer[0],xidx)
                answer[1] = min(answer[1],yidx)
                answer[2] = max(answer[2],xidx+1)
                answer[3] = max(answer[3],yidx+1)
    return answer