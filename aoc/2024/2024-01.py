import sys
from aoc import read_problem_input

read_problem_input()

lines = [line.split() for line in sys.stdin.readlines()]
left = [int(l) for l,r in lines]
right = [int(r) for l,r in lines]

def part_one():
    return sum(abs(r - l) for r,l in zip(sorted(left), sorted(right)))

def part_two():
    from collections import Counter
    freq = Counter(right)
    return sum(l * (freq.get(l) or 0) for l in left)

print(f'Part 1 sum: {part_one()}')
print(f'Part 2 sum: {part_two()}')
