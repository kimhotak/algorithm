import sys

max_num = 123456*2
prime = [True]*(max_num+1)
prime[0] = prime[1] = False
for i in range(int(max_num**0.5)+1):
    if prime[i]:
        for j in range(i*i,max_num+1,i):
            prime[j] = False

while n := int(sys.stdin.readline()):
    print(sum(prime[n+1:2*n+1]))