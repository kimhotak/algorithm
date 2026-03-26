import heapq
def solution(scoville, K):
    heapq.heapify(scoville)
    answer = 0
    while scoville[0] < K and len(scoville) > 1:
        f = heapq.heappop(scoville)
        s = heapq.heappop(scoville)
        heapq.heappush(scoville, f+s*2)
        answer+=1
    if scoville[0] < K:
        return-1
    return answer