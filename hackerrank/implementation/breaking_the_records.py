import sys
from itertools import accumulate

sys.stdin = open('input.txt', 'r')
input()  #ignore
score = list(map(int, input().split()))

best = len(set(s for s, b in zip(score, list(accumulate(score, max))) if s == b)) - 1
worst = len(set(s for s, w in zip(score, list(accumulate(score, min))) if s == w)) - 1

print(best, worst)
