import sys

def is_prime(n):
    if n < 2:
        return False
    if n % 2 == 0:
        if n == 2:
            return True
        else:
            return False
    for i in range(3,int(n**0.5)+1,2):
        if n%i == 0:
            return False
    return True

input = sys.stdin.readline
test_case = int(input())
for _ in range(test_case):
    n = int(input())
    while not is_prime(n):
        n +=1
    print(n)