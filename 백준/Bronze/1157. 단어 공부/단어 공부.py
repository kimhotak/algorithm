from collections import Counter

word = input().upper()

counter = Counter(word)
most = counter.most_common(2)

if len(most) == 2 and most[0][1] == most[1][1]:
    print('?')
else:
    print(most[0][0])