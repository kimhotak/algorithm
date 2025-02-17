import sys
input = sys.stdin.readline
t = int(input())

for _ in range(t):
    s = input().strip()
    i,j = 0,-1
    while i < len(s)//2:
        if s[i] == s[j]:
            i+=1
            j-=1
        else:
            print(0, i+1)
            break
    else:
        print(1, i+1)