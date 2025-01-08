n = int(input())
k = int(input())
answer = 0
left, right = 0, n**2
while left <= right:
    mid = (left + right) // 2
    tmp = sum(min(n,mid//i) for i in range(1,n+1))
    if tmp >= k:
        right = mid-1
        answer = mid
    else:
        left = mid + 1
print(answer)