def solution(keyinput, board):
    board = [i//2 for i in board]
    answer = [0,0]
    key_move = {'up':[0,1],'down':[0,-1],'left':[-1,0],'right':[1,0]}
    for k in keyinput:
        temp = [a+b for a,b in zip(answer,key_move[k])]
        if not sum(t>b for t,b in zip(map(abs, temp), board)):
            answer = temp
    return answer