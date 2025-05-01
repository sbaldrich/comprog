import itertools
import re
import math
from collections import deque

with open("input.small.in") as file:
    lines = file.read().strip().split('\n')

grid = [[c for c in l] for l in lines]

box = [
    (i, j) for i, j in
    itertools.product((-1, 0, 1), (-1, 0, 1))
    if abs(i + j) == 1]

for i, l in enumerate(lines):
    m = re.search('(S)', l)
    if m:
        start = i, m.start()
        break

q = deque()
seen = set()
q.append((start[0], start[1], 0, 'x'))
steps = 0



def valid(d, ch):
    match d:
        case (-1, 0):
            return ch in {'|', '7', 'F'}
        case (0, 1):
            return ch in {'-', 'J', '7'}
        case (1, 0):
            return ch in {'|', 'L', 'J'}
        case (0, -1):
            return ch in {'-', 'L', 'F'}
    raise KeyError('blargh')


def direction(d):
    match d:
        case (-1, 0):
            return 'd'
        case (0, 1):
            return 'l'
        case (1, 0):
            return 'u'
        case (0, -1):
            return 'r'


ans = 0
while q:
    print(q)
    cr, cc, s, ed = q.popleft()

    seen.add((cr, cc))
    c = grid[cr][cc]
    grid[cr][cc] = str(s)
    ans = max(ans, s)
    print(f'at {cr, cc} : {c}, arrived by going {ed} with {s} steps')
    if c == 'S':
        for d in box:
            nr, nc = cr + d[0], cc + d[1]
            if valid(d, grid[nr][nc]):
                q.append((nr, nc, s + 1, direction(d)))
        continue
    match c:
        case '|':
            if ed == 'd':
                nr, nc = cr - 1, cc
                if (nr, nc) not in seen:
                    q.append((nr, nc, s + 1, 'd'))
            elif ed == 'u':
                nr, nc = cr + 1, cc
                if (nr, nc) not in seen:
                    q.append((nr, nc, s + 1, 'u'))
        case '-':
            if ed == 'l':
                nr, nc = cr, cc + 1
                if (nr, nc) not in seen:
                    q.append((nr, nc, s + 1, 'l'))
            elif ed == 'r':
                nr, nc = cr, cc - 1
                if (nr, nc) not in seen:
                    q.append((nr, nc, s + 1, 'r'))
        case 'J':
            if ed == 'l':
                nr, nc = cr - 1, cc
                if (nr, nc) not in seen:
                    q.append((nr, nc, s + 1, 'd'))
            elif ed == 'u':
                nr, nc = cr, cc - 1
                if (nr, nc) not in seen:
                    q.append((nr, nc, s + 1, 'r'))
        case 'L':
            if ed == 'u':
                nr, nc = cr, cc + 1
                if (nr, nc) not in seen:
                    q.append((nr, nc, s + 1, 'l'))
            elif ed == 'r':
                nr, nc = cr - 1, cc
                if (nr, nc) not in seen:
                    q.append((nr, nc, s + 1, 'd'))
        case 'F':
            if ed == 'r':
                nr, nc = cr + 1, cc
                if (nr, nc) not in seen:
                    q.append((nr, nc, s + 1, 'u'))
            elif ed == 'd':
                nr, nc = cr, cc + 1
                if (nr, nc) not in seen:
                    q.append((nr, nc, s + 1, 'l'))
        case '7':
            if ed == 'l':
                nr, nc = cr + 1, cc
                if (nr, nc) not in seen:
                    q.append((nr, nc, s + 1, 'u'))
            elif ed == 'd':
                nr, nc = cr, cc - 1
                if (nr, nc) not in seen:
                    q.append((nr, nc, s + 1, 'r'))
print(*grid, sep='\n')
print(ans)
