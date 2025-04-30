import sys

input = sys.stdin.readline

n = int(input())
foods_temperture = [i for i in map(int, input().split())]
inductions = [0] * 3
btn_cnt = 0

ind2food = [[min(abs(i-j), -abs(i-j)+10) for i in range(10)] for j in range(10)]
# 모든 인덕션 온도에서 음식온도로 가는거 찾아놓자

for food_tem in foods_temperture:
    min_idx, min_value = 4, 10
    for idx, induct in enumerate(inductions):
        if ind2food[induct][food_tem] < min_value:
            min_value = ind2food[induct][food_tem]
            min_idx = idx
    inductions[min_idx] = food_tem
    btn_cnt += min_value
    
print(btn_cnt)