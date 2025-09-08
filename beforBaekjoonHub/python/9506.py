def is_perfect(n):
    div = [i for i in range(1,n//2+1) if n%i == 0]
    if n == sum(div):
        print(f'{n} = {' + '.join(map(str, div))}')
    else:
        print(f'{n} is NOT perfect.')

while True:
    n = int(input())
    if n == -1:
        break
    is_perfect(n)