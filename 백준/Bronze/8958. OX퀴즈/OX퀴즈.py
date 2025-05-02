import sys
input = sys.stdin.readline

for _ in range(int(input())):
    score = 0
    o_score = 0
    for i in input().strip():
        if i  == 'O':
            o_score +=1
            score += o_score
        else:
            o_score = 0
    print(score)