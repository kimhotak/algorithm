import math

room_num = input()

plastic_num = [0]*10

for n in room_num:
    plastic_num[int(n)] += 1

plastic_num[6] = math.ceil((plastic_num[6]+plastic_num[9])/2)
plastic_num[9] = plastic_num[6]

print(max(plastic_num))