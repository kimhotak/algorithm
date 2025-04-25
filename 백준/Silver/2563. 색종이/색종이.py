import sys
color = [map(int,i.split()) for i in sys.stdin.readlines()[1:]]
white = [[False for _ in range(100)]for _ in range(100)]

for x, y in color:
    for i in range(x,x+10):
        for j in range(y,y+10):
            white[i][j] = True

print(sum(sum(i)for i in white))