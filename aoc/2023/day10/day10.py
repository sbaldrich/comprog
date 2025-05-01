import itertools
import re
import math
from collections import deque

with open("input.large.in") as file:
    lines = file.read().strip().split('\n')

grid = [[' '] * (len(lines[0]) * 2 + 1) for i in range(2 * len(lines) + 1)]
for i, l in enumerate(lines):
    grid[2*i + 1][1::2] = l


for i, l in enumerate(grid):
    for j, c in enumerate(l):
        if c == 'S':
            start = i, j
            break


q = deque()
seen = set()
# row, col, steps, entry direction (i.e if last movement was up, then this should be down)
q.append((*start, 0, 'x'))
steps = 0
max_steps = 0

while q:
    cr, cc, s, ed = q.popleft()

    seen.add((cr, cc))
    ch = grid[cr][cc]
    grid[cr][cc] = '*'
    max_steps = max(max_steps, s)

    if ch == 'S':
        box = [
            (i, j)
            for i, j in itertools.product([-2, 0, 2], repeat=2)
            if abs(i + j) == 2
        ]
        valid = ['7|F', '-FL', '-J7', '|LJ']
        next_entry_dir = ['d', 'r', 'l', 'u']
        for (r, c), symbols, d in zip(box, valid, next_entry_dir):
            nr, nc = cr + r, cc + c
            if nr >= 0 and nc >= 0 and grid[nr][nc] in symbols:
                nr = nr - r // 2
                nc = nc - c // 2
                q.append((nr, nc, s + 1, d))
        continue
    match ch:
        case ' ' | '|' | '-':
            dir_delta = {
                'd': (-1, 0),
                'u': (1, 0),
                'r': (0, -1),
                'l': (0, 1)
            }
            next_ed = {d: d for d in ['d', 'u', 'r', 'l']}
        case 'J':
            dir_delta = {
                'u': (0, -1),
                'l': (-1, 0)
            }
            next_ed = {'l': 'd', 'u': 'r'}
        case 'L':
            dir_delta = {
                'u': (0, 1),
                'r': (-1, 0)
            }
            next_ed = {'u': 'l', 'r': 'd'}
        case 'F':
            dir_delta = {
                'r': (1, 0),
                'd': (0, 1)
            }
            next_ed = {'r': 'u', 'd': 'l'}
        case '7':
            dir_delta = {
                'l': (1, 0),
                'd': (0, -1)
            }
            next_ed = {'l': 'u', 'd': 'r'}
    r, c = dir_delta[ed]
    nr, nc = cr + r, cc + c
    if (nr, nc) not in seen:
        q.append((nr, nc, s + (1 if ch != ' ' else 0), next_ed[ed]))


# part 1
print(max_steps)

box = [
    (i, j)
    for i, j in itertools.product([-1, 0, 1], repeat=2)
    if abs(i + j) == 1
]

flood_queue = deque([(0, 0), (0, len(grid[0]) - 1),
                    (len(grid) - 1, 0), (len(grid) - 1, len(grid[0]) - 1)])
seen = {(0, 0)}
visited = set()
while flood_queue:
    cr, cc = flood_queue.popleft()
    grid[cr][cc] = '#'
    visited.add((cr, cc))
    for r, c in box:
        nr, nc = cr + r, cc + c
        if (nr, nc) not in seen and nr >= 0 and nr < len(grid) and nc >= 0 and nc < len(grid[0]):
            ch = grid[nr][nc]
            if ch != '*':
                flood_queue.append((nr, nc))
                seen.add((nr, nc))

# part 2
print(sum(sum(c not in ('*', ' ', '#') for c in l) for l in grid))
