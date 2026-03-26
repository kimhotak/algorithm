def solution(storage, requests):
    n,m = len(storage), len(storage[0])
    storage = [[j for j in i]for i in storage]

    def canpick(i,j,visit):
        if i<0 or j<0 or i>=n or j>=m: # 끝에 닿았는가
            return True
        
        elif visit and storage[i][j] is not None: # None이 아닌경우,  
            return False
        
        elif (i,j) in visit: # 방문 했던 좌표
            return False
        
        visit.add((i,j))
        for di,dj in [(1,0),(-1,0),(0,1),(0,-1)]:
            if canpick(i+di,j+dj,visit):
                return True
        return False
        
    
    for req in requests:
        pick_list = []
        for i in range(n):
            for j in range(m):
                if storage[i][j] == req[0]:
                    if len(req) == 2: # 크레인
                        pick_list.append((i,j))
                    else: # 지게차
                        visit = set()
                        if canpick(i,j,visit):
                            pick_list.append((i,j))
        for i,j in pick_list:
            storage[i][j] = None
    return sum(sum(s != None for s in stor) for stor in storage )        