from aoc import *
import re

read_problem_input()

lines = [l.strip() for l in sys.stdin.readlines()]
padded = ['.' * (len(lines[0]) + 2)] + [f".{l}." for l in lines] + ['.' * (len(lines[0]) + 2)]
n = len(padded[0])
word_search = ''.join(padded)

def count(*patterns):
    ans = 0
    for pattern in patterns:
        regex = re.compile(pattern)
        for _ in regex.finditer(word_search):
            ans += 1
    return ans

def part_one():
    return count(
        *[
            f'(?=(?:(X)|(S)).{{{n - i}}}(?:(?(1)M|A)).{{{n - i}}}(?:(?(1)A|M)).{{{n - i}}}(?:(?(1)S|X)))'
            for i in [0, 1, 2, n]
    ])

def part_two():
    return count(f'(?=(?:(M)|(S)).(?:(M)|(S)).{{{n - 2}}}A.{{{n - 2}}}(?:(?(3)S|M)).(?:(?(1)S|M)))')


print(f"Part one count: {part_one()}")
print(f"Part two count: {part_two()}")
