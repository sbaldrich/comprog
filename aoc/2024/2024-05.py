from aoc import *
import functools

read_problem_input()

lines = [l.strip() for l in sys.stdin]
rules = lines[:lines.index('')]
updates = lines[lines.index('') + 1:]


def solve(part_one):
    ans = 0
    for upd in updates:
        pages = upd.split(',')
        pages_set = set(pages)
        relevant_rules = [
            (l, r) for l, r in (rule.split('|') for rule in rules)
            if l in pages_set and r in pages_set
        ]

        m = {}
        for l, r in relevant_rules:
            m[(l, r)], m[(r, l)] = -1, 1

        sorted_pages = sorted(pages, key=functools.cmp_to_key(lambda p, q: m[p, q]))

        if (pages == sorted_pages) == part_one:
            ans += int(sorted_pages[len(pages) // 2])
    return ans


print(f"Part one sum {solve(True)}")
print(f"Part two sum {solve(False)}")
