# name: Sock Merchant
# source: https://www.hackerrank.com/challenges/sock-merchant
# judge: Hackerrank
# tags: ad-hoc, warmup

from collections import Counter
input()
c = Counter(list(map(int, input().split())))
print(sum([x // 2 for x in c.values()]))

