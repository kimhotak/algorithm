import sys
input = sys.stdin.readline

while 1:
    n, k = map(int, input().split())
    if n == k == 0:
        break

    num = list(map(int, input().split()))
    parent_list = [None] * (max(num) + 1)
    parent_idx, child_idx = 0, 1
    while child_idx < n:
        parent_list[num[child_idx]] = num[parent_idx]
        if child_idx + 1 < n and num[child_idx + 1] - num[child_idx] != 1:
            parent_idx += 1
        child_idx += 1


    p = parent_list[k]
    if p == None:
        print(0)
        continue
    pp = parent_list[p]
    if pp == None:
        print(0)
        continue
    
    ps = set()
    for child, parent in enumerate(parent_list):
        if parent == pp and child != p:
            ps.add(child)

    answer = 0
    for child, parent in enumerate(parent_list):
        if parent in ps:
            answer += 1

    print(answer)