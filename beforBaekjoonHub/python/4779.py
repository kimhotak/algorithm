import sys

def cantorset(i):
    if i < 1:
        return '-'
    prev = cantorset(i-1)
    blank = ' '*len(prev)
    return prev + blank + prev

for line in sys.stdin:
    line = line.strip()
    if line:
        print(cantorset(int(line)))