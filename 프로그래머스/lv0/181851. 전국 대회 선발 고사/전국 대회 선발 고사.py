def solution(rank, attendance):
    ranking = {r:num for num, r in enumerate(rank) if attendance[num]}
    return sum(ranking[item]*100**(2-idx) for idx,item in enumerate(sorted(ranking.keys())[:3]))