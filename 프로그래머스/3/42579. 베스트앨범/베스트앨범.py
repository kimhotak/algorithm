from collections import defaultdict 
def solution(genres, plays):
    # 필요한 정보
    # 장르별 재생수
    # 장르내 최다 재생수
    # 고유번호 남겨야함
    answer = []
    max_genres = defaultdict(list)
    # 장르명을 키로 가지는 리스트
    # 리스트에는 노래별 재생수와 고유번호를 쌍으로 저장 [0]이 재생수 [1]이 고유번호
    for i,(g,p) in enumerate(zip(genres, plays)):
        max_genres[g].append([p,-i])
        
    for k in max_genres.keys():
        max_genres[k].sort(reverse=True)
        
    for i in sorted(max_genres, key= lambda x:sum(i[0] for i in max_genres[x]))[::-1]:
        answer.append(-max_genres[i][0][1])
        if len(max_genres[i]) != 1:
            answer.append(-max_genres[i][1][1])
    return answer