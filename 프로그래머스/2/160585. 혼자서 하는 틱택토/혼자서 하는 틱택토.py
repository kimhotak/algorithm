def solution(board):
    # 정상적이지 않은 게임의 조건
    # 후공의 개수가 선공보다 많다.
    # 게임의 종료조건 이후에 상대가 돌을 놓는다
      # 1. 선,후공 모두 한줄 이상
      # 2. 한줄이 나왔는데 상대 개수가 많은 경우
    o_cnt, x_cnt = 0,0
    for b in board:
        o_cnt += b.count('O')
        x_cnt += b.count('X')
    
    if not(x_cnt+1 == o_cnt or x_cnt == o_cnt):
        return 0
    
    line_check = []
    for b in board:
        line_check.append(b)
    
    for i in zip(*board):
        line_check.append(''.join(i))
        
    line_check.append(''.join(item[idx] for idx,item in enumerate(board)))
    line_check.append(''.join(item[2-idx] for idx,item in enumerate(board)))
    
    o_line, x_line = 0,0
    for l in line_check:
        if l == 'OOO':
            o_line +=1
        elif l == 'XXX':
            x_line +=1
        
    if o_line > 0 and x_line > 0:
        return 0
    elif o_line > x_line:
        if o_cnt != x_cnt+1:
            return 0
    elif x_line > o_line:
        if o_cnt != x_cnt:
            return 0
    return 1