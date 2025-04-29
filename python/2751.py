import sys

n = list(map(int,sys.stdin.read().split()[1:]))
n.sort()
# def quick_sort(arr, start, end):

#     if start >= end:
#         return
    
#     pivot = start
#     left = start + 1
#     right = end

#     while left <= right: # 포인터가 엇갈릴 때 까지
#         while left <= end and arr[left] <= arr[pivot]: # l포인터가 오른쪽으로 나가지 않고, 피벗보다 큰게 나올떄 까지
#             left += 1
#         while right > start and arr[right] >= arr[pivot]: # r포인터가 왼쪽으로 나가지 않고, 피벗보다 큰게 나올떄 까지
#             right -= 1
#         if left >= right: # 포인터가 엇갈렸거나 같으면
#             # 다 끝났다는 이야기, 피벗만 정리하고 끝
#             arr[right], arr[pivot] = arr[pivot], arr[right]
#         else:
#             arr[left], arr[right] = arr[right], arr[left]

#     quick_sort(arr, start, right-1)
#     quick_sort(arr, right+1, end)





# quick_sort(n, 0, len(n)-1)
print('\n'.join(map(str, n)))