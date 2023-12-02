import operator
from functools import reduce

with open("input.in") as file:
    data = [line.strip() for line in file.readlines()]

colors = ['red', 'green', 'blue']
max_dice = dict(zip(colors, [12, 13, 14]))
_total_dice = sum(max_dice.values())

possible_games_sum = 0
cube_power_sum = 0

for game in data:
    g, d = game.split(': ', 2)
    gid = int(g.split(' ')[1])
    game = [
        {x: int(y) for x, y in [tuple(reversed(x.split(' '))) for x in r.split(', ')]} for r in d.split('; ')
    ]
    possible = True
    min_cubes = {c: 0 for c in colors}

    for rm in game:
        possible &= sum(rm.values()) < _total_dice
        for c in colors:
            possible &= rm.get(c, 0) <= max_dice[c]
            min_cubes[c] = max(min_cubes.get(c), rm.get(c, 0))

    cube_power_sum += reduce(operator.mul, min_cubes.values())
    if possible:
        possible_games_sum += gid

# part 1
print(possible_games_sum)

# part 2
print(cube_power_sum)
