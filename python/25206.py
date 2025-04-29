import sys

grade = list(i.split() for i in sys.stdin.readlines())
score_board = {'A+':4.5, 'A0':4.0,
               'B+':3.5, 'B0':3.0,
               'C+':2.5, 'C0':2.0,
               'D+':1.5, 'D0':1.0,
               'F':0.0}

time_sum = 0
score_sum = 0
for _, time, score in grade:
    if score == 'P':
        continue
    score_sum += score_board[score] * float(time)
    time_sum += float(time)
print(score_sum/time_sum)