from aoc import *

read_problem_input()

lines = [list(map(int, line.split())) for line in sys.stdin.readlines()]

def safe(l):
    return all([1 <= abs(p - q) <= 3 for p, q in zip(l, l[1:])]) and (
            sorted(l) == l or sorted(l) == l[::-1]
    )


def part_one():
    return sum(safe(line) for line in lines)


def part_two():
    return sum([any([safe(l[:i] + l[i+1:]) for i in range(len(l))]) for l in lines])



# part_one()
print(f'Part 1 sum: {part_one()}')
print(f'Part 2 sum: {part_two()}')
