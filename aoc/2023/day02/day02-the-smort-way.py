import math
import re
from collections import defaultdict

with open("input.in") as file:
    data = [line.strip() for line in file.readlines()]

colors = ['red', 'green', 'blue']
max_dice = dict(zip(colors, [12, 13, 14]))

possible_games_sum = 0
cube_power_sum = 0
for game in data:
    tokens = re.sub("[:,;]", "", game).split()
    dice_count = defaultdict(int)
    for color, count in zip(tokens[3::2], tokens[2::2]):
        dice_count[color] = max(dice_count[color], int(count))
    cube_power_sum += math.prod(dice_count.values())

    possible = True
    for color in colors:
        possible &= dice_count[color] <= max_dice[color]
    if possible:
        possible_games_sum += int(tokens[1])

# part 1
print(possible_games_sum)

# part 2
print(cube_power_sum)
