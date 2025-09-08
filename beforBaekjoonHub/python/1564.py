import sys
n = int(sys.stdin.readline())
res = 1
full = 10 ** (8 + 5)
for i in range(1, n+1):
	res = res * i
	while res % 10 == 0:
		res = res // 10
	res = res % full
print(str(res)[-5:])

# 5 ** 8 : 390_625
# 5 ** 9 : 1_953_125