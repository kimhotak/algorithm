def solution(triangle):
    # 작게 밑에서부터 생각해보자
    # 바로 위 에서 양쪽중에 큰거를 선택하자 그리고 더하자
    for i in range(len(triangle)-2,-1,-1):
        for j in range(i+1):
            if triangle[i+1][j] > triangle[i+1][j+1]:
                triangle[i][j] += triangle[i+1][j]
            else:
                triangle[i][j] += triangle[i+1][j+1]
    return triangle[0][0]