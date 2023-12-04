import re
import collections

with open("input.large.in") as file:
    lines = file.read().strip().split('\n')

points = 0
matches = {}
for i, line in enumerate(lines):
    card, winners, maybes = re.split(r'[:|]', line)
    check = set(winners.split()) & set(maybes.split())
    if len(check):
        points += 1 << (len(check) - 1)
    matches[card] = len(check)

# Part 1
print(points)

# Part 2
values = list(matches.values())
cards = [1] * len(lines)

for i, v in enumerate(values):
    for j in range(i + 1, min(len(cards), i + v + 1)):
        cards[j] += cards[i]

print(sum(cards))

