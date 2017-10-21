import sys

sys.stdin = open('input.txt', 'r')

n = int(input())
a = list(map(int, input().split()))
d, m = map(int, input().split())
print(sum([sum(a[i:i+m]) == d for i in range(len(a) - m + 1)]))
