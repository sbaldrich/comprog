import re

with open("input.small.in") as file:
    lines = file.read().strip().split('\n')

grid = [[c for c in l] for l in lines]

def pad(l):
    mask = ['#'] * (2 * len(l))
    mask[1::2] = l
    return mask

grid = [pad([c for c in l]) for l in lines]

print(*grid, sep='\n')