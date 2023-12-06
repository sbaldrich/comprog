import re
import itertools
from collections import defaultdict

with open("input.small.in") as file:
    lines = file.read().strip().split('\n')

seeds = [int(d) for d in re.findall(r'\d+', lines[0])]

groups = ' '.join(lines[1:]).split('  ')

seed_ranges = [(s, s + r) for s, r in zip(*(iter(seeds),) * 2)]
delta_ranges = []
for m in groups:
    plus = []
    for e in re.finditer(r'(\d+ \d+ \d+)', m):
        d, s, x = map(int, e.group().split())
        plus.append((s, s + x, d - s))
    delta_ranges.extend(plus)
    new_seeds = []
    for seed in seeds:
        result = 0
        for start, end, delta in plus:
            if start <= seed < end:
                result += delta
        new_seeds.append(seed + result)
    seeds = new_seeds

# part 1
print(min(seeds))


