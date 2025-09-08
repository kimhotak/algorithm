import sys
t = int(sys.stdin.readline())
N = tuple(map(int,sys.stdin.read().split()))

m = max(N)
prime = [True]*(m+1)
prime[0] = prime[1] = False
for i in range(2,int(m**0.5)+1):
    if prime[i]:
        for j in range(i*i,m+1,i):
            prime[j] = False

for n in N:
    print(sum(prime[i] and prime[n-i] for i in range(1,n//2+1)))