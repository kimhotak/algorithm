import sys
n = int(sys.stdin.read())
cnt = 0
idx = 0
while cnt < n:
    if '666' in str(idx):
        cnt +=1
    idx +=1
print(idx-1)