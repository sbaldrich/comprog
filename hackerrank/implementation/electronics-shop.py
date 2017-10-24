# name: Electronics Shop
# source: https://www.hackerrank.com/challenges/electronics-shop
# judge: Hackerrank
# tags: ad-hoc, warmup
import sys
sys.stdin = open('input.txt')
from itertools import product
s, n, m = list(map(int, input().split()))
k = list(map(int, input().split()))
u = list(map(int, input().split()))
comb = list(filter(lambda x: x <= s, list(x + y for x, y in product(k, u))))
print(max(comb) if len(comb) else -1)
