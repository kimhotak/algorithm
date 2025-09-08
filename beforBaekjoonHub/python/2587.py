import sys

n = list(map(int, sys.stdin.read().split()))
print(sum(n)//5)

def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[0]
    left = [i for i in arr[1:] if i<=pivot]
    right = [i for i in arr[1:] if i > pivot]
    return quick_sort(left)+[pivot]+quick_sort(right)

n = quick_sort(n)
print(n[2])

# import sys
# n = list(map(int, sys.stdin.read().split()))
# print(sum(n)//5)
# print(sorted(n)[2])