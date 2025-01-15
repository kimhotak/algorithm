import sys
import queue

def print_number(m):
    Q = queue.Queue()
    for idx, item in enumerate(map(int, sys.stdin.readline().split())):
        Q.put((item, idx))
    
    cnt = 1
    while True:
        first = Q.get()
        important = False
        for _ in range(Q.qsize()):
            temp = Q.get()
            if first[0] < temp[0]:
                important = True
            Q.put(temp)

        if important:
            Q.put(first)
        elif first[1] == m:
            return cnt
        else:
            cnt += 1


testcase = int(input())
for i in range(testcase):
    n, m = map(int, sys.stdin.readline().split())
    print(print_number(m))