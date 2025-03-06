from functools import lru_cache

def solution(numbers, target):
    @lru_cache(None)  # 메모이제이션 적용
    def calc(i, S):
        if i == len(numbers):
            return 1 if S == target else 0
        return calc(i + 1, S + numbers[i]) + calc(i + 1, S - numbers[i])

    return calc(0, 0)