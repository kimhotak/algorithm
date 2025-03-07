def solution(participant, completion):
    participant.sort()
    completion.sort()
    completion.append(-1)
    for p,c in zip(participant, completion):
        if p!=c:
            return p