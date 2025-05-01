from aoc import *
import re

read_problem_input()

memory = sys.stdin.read()


def part_one():
    return sum([int(i) * int(j) for i, j in re.findall(r'mul\((\d{1,3}),(\d{1,3})\)', memory)])


def part_two():
    go = True
    ans = 0
    for x, i, j in re.findall(r"(mul\((\d{1,3}),(\d{1,3})\)|don't|do)", memory):
        if x == "don't":
            go = False
            continue
        if x == "do":
            go = True
            continue
        if not go:
            continue
        ans += int(i) * int(j)

    return ans


print(f'Part 1 sum: {part_one()}')
print(f'Part 2 sum: {part_two()}')
