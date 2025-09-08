from collections import deque

deck = deque(i for i in range(1, int(input())+1))
while len(deck) > 1:
    deck.popleft()
    deck.append(deck.popleft())

print(deck.pop())