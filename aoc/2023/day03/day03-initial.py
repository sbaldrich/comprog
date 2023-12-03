from collections import defaultdict
import math

with open('input.large.in') as file:
    data = file.readlines()

n, m = len(data), len(data[0].strip())

grid = ['.' * m]

for row in data:
    grid.append(f".{row.strip()}.")

grid.append('.' * m)

delta_r = [-1, -1, -1, 0, 0, 1, 1, 1]
delta_c = [-1, 0, 1, -1, 1, -1, 0, 1]
possible_gears = defaultdict(set)
valid_sum = 0
i = 1
while i < n + 1:
    j = 1
    while j < m + 1:
        if grid[i][j].isdigit():
            valid = False
            possible_gears_here = set()
            start = j
            end = j + 1
            while end < m + 1 and grid[i][end].isdigit():
                end += 1
            j = end
            for k in range(start, end):
                for (r, c) in zip(delta_r, delta_c):
                    valid |= (grid[i + r][k + c] != '.' and not grid[i + r][k + c].isdigit())
                    if grid[i + r][k + c] == '*':
                        possible_gears_here.add((i + r, k + c))
            if valid:
                part_number = int(grid[i][start:end])
                valid_sum += part_number
                for pgh in possible_gears_here:
                    possible_gears[pgh].add(part_number)
        j += 1
    i += 1

# part 1
print(valid_sum)

# part 2
gear_ratios = [math.prod(v) for p, v in possible_gears.items() if len(v) == 2]
# print(possible_gears)
print(sum(gear_ratios))