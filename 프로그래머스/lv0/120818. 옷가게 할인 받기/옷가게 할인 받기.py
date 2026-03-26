def solution(price):
    dc = 1
    if price >= 500_000:
        dc = 0.8
    elif price >= 300_000:
        dc = 0.9
    elif price >= 100_000:
        dc = 0.95
    return int(price * dc)