import sys
num, cnt = sys.stdin.readline().split()
cnt = int(cnt)

print(int(num,cnt))
# changed_num = 0
# for idx, item in enumerate(num):
#     if item.isalpha():
#         temp = ord(item)-ord('A')+10
#     else:
#         temp = int(item)
#     changed_num += temp * (cnt**(len(num)- idx -1))
# print(changed_num)
