import re

with open("input.in") as file:
    lines = [line.strip() for line in file.readlines()]


def part_one():
    numbers = [re.findall(r'\d', line) for line in lines]
    return sum(int(n[0] + n[-1]) for n in numbers)

# Initially went with a quick and dirty n^2 solution that checked every pair of indices of a non-digit token
# but stumbled into this solution in reddit: https://github.com/fuglede/adventofcode/blob/master/2023/day01/solutions.py
def part_two():
    def nums(s):
        return (
            s.replace('one', 'one1one')
            .replace('two', 'two2two')
            .replace('three', 'three3three')
            .replace('four', 'four4four')
            .replace('five', 'five5five')
            .replace('six', 'six6six')
            .replace('seven', 'seven7seven')
            .replace('eight', 'eight8eight')
            .replace('nine', 'nine9nine')
        )

    numbers = [re.findall(r'\d', nums(l)) for l in lines]
    return sum(int(n[0] + n[-1]) for n in numbers)


print(f'Part 1 calibration: {part_one()}')
print(f'Part 2 calibration: {part_two()}')
