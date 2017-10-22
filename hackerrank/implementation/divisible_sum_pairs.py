from itertools import combinations

n, k = map(int, input().split())
a = map(int, input().split())

print(len([(x, y) for x, y in combinations(enumerate(a), 2) if x[0] < y[0] and (x[1] + y[1]) % k == 0]))
