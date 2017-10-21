from itertools import accumulate

input()  # ignore it.
a = list(map(int, input().split()))
m = max(a)
print(sum(i == m for i in a))
# This would be a more interesting problem ¬¬ 
#
# acc = list(accumulate(a, max))
# print(sum([1 for i, j in zip(a, acc) if i >= j]))
