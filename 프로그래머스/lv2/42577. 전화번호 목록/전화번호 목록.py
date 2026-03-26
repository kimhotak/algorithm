def solution(phone_book):
    # 모든 전화번호를 집합에 저장
    phone_set = set(phone_book)
    
    # 각 전화번호마다 모든 접두어를 확인합니다.
    for number in phone_book:
        # 접두어는 길이가 1부터 len(number)-1 까지
        for i in range(1, len(number)):
            # 현재 전화번호의 접두어가 집합에 존재하는 경우
            if number[:i] in phone_set:
                return False
    return True