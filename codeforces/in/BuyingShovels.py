import math

t = int(input())
for tc in range(t):
    n, k = [ int(_) for _ in input().split() ]
    D = set()
    i = 1
    while i <= math.sqrt(n):
        if n % i == 0:
            D.add(i)
            D.add(n / i)
        i += 1
    d = max( [d for d in D if d <= k] )
    print(int(n // d))

