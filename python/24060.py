import sys
input = sys.stdin.readline
n, k = map(int,input().split())
arr = list(map(int,input().split()))
def merge_sort(A, p, r):
    if p < r:
        q = (p + r) // 2
        merge_sort(A, p, q)
        merge_sort(A, q + 1, r)
        merge(A, p, q, r)

def merge(A, p, q, r):
    global k
    i = p
    j = q+1
    tmp = []
    while i <= q and j <= r:
        if A[i] <= A[j]:
            tmp.append(A[i])
            i+=1
        else:
            tmp.append(A[j])
            j+=1
    while i <= q:
        tmp.append(A[i])
        i+=1
    while j <= r:
        tmp.append(A[j])
        j+=1
    for l in range(len(tmp)):
        A[p + l] = tmp[l]
        k -= 1
        if k == 0:
            print(tmp[l])
            exit()

merge_sort(arr, 0, len(arr)-1)
if k > 0:
    print(-1)