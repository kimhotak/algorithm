import sys

words = list(set(sys.stdin.read().split()[1:]))
words.sort(key= lambda x: (len(x),x))
print('\n'.join(words))