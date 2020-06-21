import math
for tc in range(int(input())):
    n, m = [ int(_) for _ in input().split() ]
    iiprint(int(math.ceil(n * m / 2)))
