import sys
ball = list(zip(*[list(map(int,i.split())) for i in sys.stdin.readlines()[1:]]))
print((max(ball[0])-min(ball[0])) * (max(ball[1])-min(ball[1])))