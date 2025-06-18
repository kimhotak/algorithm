import sys
input = sys.stdin.readline
n = int(input())
m = int(input())
s = input()
string = 'I' + 'OI' * n
cnt = 0
for i in range(m-len(string)+1):
    if s[i] == 'I' and s[i:i+len(string)] == string:
        cnt += 1
print(cnt)