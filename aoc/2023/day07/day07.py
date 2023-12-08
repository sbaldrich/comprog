from collections import Counter
import functools

with open("input.large.in") as file:
    lines = file.read().strip().split('\n')

crd_str = ['A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4', '3', '2', '*']


def strength(hand):
    c = Counter(hand)
    js = c['*']
    if js == 5:
        return 6
    del c['*']
    cc = [count for (_, count) in c.most_common()]
    t, *r = cc
    t += js
    if t == 5 or t == 4:
        return t + 1
    if t == 3:
        return 4 if r[0] == 2 else 3
    if t == 2:
        return 2 if r[0] == 2 else 1
    return 0


def compare(h1, h2):
    c1, _ = h1
    c2, _ = h2
    s = strength(c1) - strength(c2)
    if s:
        return s
    for ch1, ch2 in zip(c1, c2):
        if ch1 == ch2:
            continue
        return crd_str.index(ch2) - crd_str.index(ch1)
    return 0


hands = [(c, int(d)) for c, d in [line.split() for line in lines]]

sorted_hands = sorted(hands, key=functools.cmp_to_key(compare))

# part 1
print(sum([i * bid for i, (_, bid) in enumerate(sorted_hands, 1)]))

# part 2
hands_with_jokers = [(c.replace('J', '*'), int(d)) for c, d in [line.split() for line in lines]]
sorted_hands_with_jokers = sorted(hands_with_jokers, key=functools.cmp_to_key(compare))

print(sum([i * bid for i, (_, bid) in enumerate(sorted_hands_with_jokers, 1)]))
