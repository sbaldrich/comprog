# name: Bon Appetit
# source: https://www.hackerrank.com/challenges/bon-appetit
# judge: Hackerrank
# tags: ad-hoc, warmup

n, k = list(map(int, input().split()))
c = list(map(int, input().split()))
d = int(input())
c.pop(k)
amount = sum(c) // 2
print('Bon Appetit' if d == amount else d - amount)
