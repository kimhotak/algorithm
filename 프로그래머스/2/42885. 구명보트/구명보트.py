def solution(people, limit):
    people.sort()
    a,b = 0,len(people)-1
    answer=0
    while a < b:
        if people[a]+people[b] <= limit:
            a+=1
            b-=1
            answer+=1
        else:
            b-=1
            answer+=1
    if a==b:
        answer+=1
    return answer