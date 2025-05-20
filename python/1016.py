min_num, max_num = map(int,input().split())

A = [True] * (max_num - min_num + 1)
# min_num + A의 인덱스로 사용

i = 2
while i * i <= max_num:
    ii = i * i
    start = ((min_num + ii - 1) // ii) * ii
    for j in range(start, max_num+1, ii):
        A[j-min_num] = False
    i += 1

print(sum(A))