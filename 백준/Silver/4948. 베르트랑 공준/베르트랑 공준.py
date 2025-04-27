import sys

max = 123456*2
prime = [True]*(max+1)
prime[0] = prime[1] = False
for i in range(int(max**0.5)+1):
    if prime[i]:
        for j in range(i*i,max+1,i):
            prime[j] = False

while n := int(sys.stdin.readline()):
    print(sum(prime[n+1:2*n+1]))