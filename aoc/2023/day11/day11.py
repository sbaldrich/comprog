import itertools

with open("input.large.in") as file:
    lines = file.read().strip().split('\n')

m = len(lines[0])
xcols = set(range(m))
xrows = set()
galaxies = []

for i, line in enumerate(lines):
    ecols = set(j for j, c in enumerate(line) if c == '.')
    galaxies.extend((i, j) for j, c in enumerate(line) if c == '#')
    xcols &= ecols
    if len(ecols) == m:
        xrows.add(i)

total = 0
for g1, g2 in itertools.combinations(galaxies, 2):
    p, q, r, s = *g1, *g2
    d = abs(r - p) + abs(s - q)
    xrows_inb = len([xr for xr in xrows if p < xr < r or r < xr < p])
    xcols_inb = len([xc for xc in xcols if q < xc < s or s < xc < q])
    d = d - xrows_inb + 1000000 * xrows_inb
    d = d - xcols_inb + 1000000 * xcols_inb 
    total += d

print(total)
