# Just see this very cool solution by fuglede:
# https://github.com/fuglede/adventofcode/blob/master/2023/day03/solutions.py

import collections
import itertools
import math
import re

with open('input.in') as file:
    lines = file.read().strip().split('\n')

bounds = list(itertools.product((-1, 0, 1), (-1, 0, 1)))
symbols = {
    (i, j)
    for i, l in enumerate(lines)
    for j, x in enumerate(l)
    if x != '.' and not x.isdigit()
}

sum_of_parts = 0
parts_by_symbol = collections.defaultdict(set)
for i, l in enumerate(lines):
    for match in re.finditer(r'\d+', l):
        n = int(match.group(0))
        boundary = {
            (i + di, j + dj)
            for di, dj in bounds
            for j in range(match.start(), match.end())
        }
        if symbols & boundary:
            sum_of_parts += n
        for symbol in symbols & boundary:
            parts_by_symbol[symbol].add(n)

# part 1
print(sum_of_parts)

# part 2
print(sum(math.prod(v) for v in parts_by_symbol.values() if len(v) == 2))
