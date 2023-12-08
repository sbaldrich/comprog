import re
from functools import reduce

with open("input.large.in") as file:
    lines = file.read().strip().split('\n')


def gcd(a, b):
    if b:
        return gcd(b, a % b)
    return a


def lcm(a, b):
    return a * b // gcd(a, b)


def explore(start):
    current = (start, 0)
    count = 0
    seen = set()
    states = []
    while current not in seen:
        l, s = current
        states.append((l, count))
        count += 1
        seen.add((l, s % len(steps)))
        current = (path[l][steps[s]], (s + 1) % len(steps))
    return states


steps, *path = lines
steps = [0 if c == 'L' else 1 for c in steps]

path = {f: (l, r)
        for (f, l, r) in (re.split(r'\W+', p)[:-1] for p in path[1:])}

# part 1
print(min(c for (l, c) in explore('AAA') if l == 'ZZZ'))

# part 2
cycles = [[cnt for (loc, cnt) in explore(start) if loc[-1] == 'Z'] for start in path if start[-1] == 'A']

print(reduce(lcm, [n for c in cycles for n in c]))
