import sys

input = sys.stdin.readline
t = int(input())
n = int(input())
A = list(map(int, input().split()))
m = int(input())
B = list(map(int, input().split()))

# 입력: 리스트
# 출력: 부 배열의 합들이 저장된 리스트
def part_sum(find:list):
    len_find = len(find)
    result = []
    for i in range(len_find):
        tmp = 0
        for j in range(i,len_find):
            tmp += find[j]
            result.append(tmp)
    return result

A = part_sum(A)
B = part_sum(B)
n = len(A)
m = len(B)

A.sort()
B.sort(reverse=True)

# 입력: 리스트, 인덱스
# 출력: 인덱스와 같은 숫자가 붙어서 있는 개수를 반환
def cnt_same_num(L, idx):
    len_L = len(L)
    num = L[idx]
    i = idx
    while i < len_L and L[i] == num:
        i += 1
    return i - idx

answer = 0
a_idx, b_idx = 0, 0

while a_idx < n and b_idx < m:
    if A[a_idx] + B[b_idx] > t:
        b_idx += 1
    elif A[a_idx] + B[b_idx] < t:
        a_idx += 1
    else: # A[a_idx] + B[b_idx] == t:
        a_cnt = cnt_same_num(A, a_idx)
        b_cnt = cnt_same_num(B, b_idx)
        a_idx += a_cnt
        b_idx += b_cnt
        answer += a_cnt * b_cnt

print(answer)


# 1번째 접근
# A 배열과 B 배열에서 나올 수 있는 것들을 dict 로 저장해놓는다.
# 만약 있으면 개수를 더한다.
# 1000부터 1까지 더한 개수 이므로 약 500,000번 연산 *2  = 1,000,000 가능
# A의 키 값 순회하면서 T-A(순회한 키값)이 B dict에 있으면 더한다.

# 메모리 초과
# 촤악의 경우 배열의 길이가 500,000개의 부분합이 생긴다.
# 딕셔너리 원소당 100byte, 1,000,000 * 100byte
# 메모리 사용량이 100MB 이상 될 수 있어 메모리 초과


# 2번째 접근
# 메모리에서 터졌고 속도 많이 남는듯,
# 속도랑 트레이드 오프 할수 있는게 뭐가있을까
# 딕셔너리 리스트로 바꾸면 가능한가??
# 리스트로 바꾸면 어떻게 찾지 여러개인데
# 2개 정렬, 역순 정렬 하고 넘치고 부족하고 따라 인덱스 조절?
# 정렬 가능한가 500,000 * 18.9
# print(math.log2(500000)*500000)
# 18.931568569324174
# 약 9,500,000
# 가능할것 같다.