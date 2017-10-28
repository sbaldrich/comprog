# name: Drawing Book
# source: https://www.hackerrank.com/challenges/drawing-book
# judge: Hackerrank
# tags: ad-hoc, warmup
n = int(input())
p = int(input())
left = p // 2
right = ((n + (n % 2 == 0)) - p) // 2
print(min(left, right))
