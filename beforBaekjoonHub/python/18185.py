import sys
input = sys.stdin.readline
n = int(input())
A = list(map(int, input().split()))

price = [3, 5, 7]
answer = 0
for i in range(n-2):
    for j in (2,3,2,1)[int(A[i+1]<=A[i+2]): ]:

        if A[i+1] > A[i+2]:
            tmp = min(A[i], A[i+1]-A[i+2])
        else:
            tmp = min(A[i:i+j])
            
        for k in range(j):
            A[i+k] -= tmp
        answer += tmp * price[j-1]
tmp = min(A[-2:])
A[-2] -= tmp
A[-1] -= tmp
answer += tmp * price[1]
answer += sum(A[-2:])*price[0]
print(answer)

# n개의 공장
# 1개 연속이면 3원
# 2개 연속이면 5원
# 3개 연속이면 7원

# 시간복잡도 고려
# 0.5초 50,000,000번 연산 가능
# n의 크기 1,000
# A의 크기 1,000

# 만약 4개, 5개 라면?
# 3개를 최대한 많이 묶고 남는거 묶는게 최소

# 반례 1211
# 중간이 끊기는게 더 값이 작아짐
# i+2가 i+1 보다 작으면 끊김
