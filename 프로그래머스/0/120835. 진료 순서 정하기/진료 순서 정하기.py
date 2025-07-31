def solution(emergency):
    em_dict = {item: idx+1 for idx, item in enumerate(reversed(sorted(emergency)))}
    return [em_dict[e] for e in emergency]