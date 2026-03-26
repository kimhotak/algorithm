def solution(A, B):
    # 횟수를 반환 그러면 A의 순서는 무시
    # 역순 정렬 이후 B가 이기는 경우를 카운트 하면 될듯
    
    A.sort(reverse=True)
    B.sort(reverse=True)
    answer = 0
    for a in A:
        if a < B[answer]:
            answer += 1
    return answer