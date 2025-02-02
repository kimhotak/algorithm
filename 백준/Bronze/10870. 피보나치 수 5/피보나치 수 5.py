# from functools import lru_cache

# @lru_cache(maxsize=None)
def fibo(n):
    if n <= 1:
        return n
    return fibo(n-2) + fibo(n-1)
print(fibo(int(input())))