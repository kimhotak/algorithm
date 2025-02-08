import sys

n = int(sys.stdin.readline())
pool = [[i for i in range(n,0,-1)],[],[]]
log = [0]
def hanoi(n, start, mid, end):
    if n == 1:
        log[0] +=1
        log.append(f'{start+1} {end+1}')
        pool[end].append(pool[start].pop())
        return
    hanoi(n-1, start, end, mid)
    log[0]+=1
    log.append(f'{start+1} {end+1}')
    pool[end].append(pool[start].pop())
    hanoi(n-1, mid, start, end)

hanoi(n, 0, 1, 2)
log[0] = str(log[0])
print('\n'.join(log))