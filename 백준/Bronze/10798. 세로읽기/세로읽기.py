import sys
from collections import deque
words = list(deque(l) for l in sys.stdin.read().split())

while any(words):
    for w in words:
        if w:
            print(w.popleft(),end='')