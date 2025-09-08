m = int(input())
n = int(input())

# def is_prime(x):
#     if x < 2:
#         return False
#     for i in range(2, int(x ** 0.5) + 1):
#         if x % i == 0:
#             return False
#     return True

# nums = [i for i in range(m, n+1) if is_prime(i)]

# if nums:
#     print(sum(nums))
#     print(nums[0])
# else:
#     print(-1)

# 아리스토테네스 체 풀이
is_prime = [True] * (n+1)
is_prime[0] = is_prime[1] = False
for i in range(2,int(n**0.5)+1):
    if is_prime[i]:
        for j in range(i*i,n+1,i):
            is_prime[j] = False
if any(is_prime[m:]):
    print(sum(i for i in range(m,n+1) if is_prime[i]))
    print(m+is_prime[m:].index(True))
else:
    print(-1)