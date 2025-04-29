def is_group_word(word):
    used_chars = set()
    prev_char = None

    for char in word:
        if char in used_chars and char != prev_char:
            return False
        used_chars.add(char)
        prev_char = char  # 현재 문자를 이전 문자로 저장

    return True


n = int(input())  # 단어 개수 입력
answer = sum(is_group_word(input()) for _ in range(n))
print(answer)
