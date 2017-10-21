import sys

# sys.stdin = open('input.txt')

input()  # ignore
a = list(map(int, input().split()))
b = list(map(int, input().split()))
m = max(b)
print(len([n for n in range(1, m + 1) if all(n % i == 0 for i in a) and all(i % n == 0 for i in b)]))
