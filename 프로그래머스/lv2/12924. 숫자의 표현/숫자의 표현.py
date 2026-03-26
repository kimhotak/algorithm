def solution(n):
    answer = 0
    for b in range(1, int((2 * n) ** 0.5) + 1):  # b는 1부터 시작해야 함
        if (2 * n - b * (b + 1)) % (2 * (b + 1)) == 0:
            answer += 1
    return answer
