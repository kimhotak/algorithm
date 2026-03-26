def solution(picture, k):
    return [''.join(picture[r//k][c//k] for c in range(len(picture[0])*k)) for r in range(len(picture)*k)]