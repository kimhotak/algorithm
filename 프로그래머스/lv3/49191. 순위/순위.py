def solution(n, results):
    answer = 0
    # n-1에 넣는다
    result_table = {i:[set(),set()]for i in range(1,n+1)}
    for win,lose in results:
        result_table[win][1].add(lose)
        result_table[lose][0].add(win)
        
    for player, [win_set, lose_set] in result_table.items():
        for w in win_set:
            for l in lose_set:
                result_table[w][1].add(l)
                result_table[l][0].add(w)
                
    for win_set, lose_set in result_table.values():
        if len(win_set)+len(lose_set) == n-1:
            answer += 1
    return answer