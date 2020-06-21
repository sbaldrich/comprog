for __ in range(int(input())):
    n, x, m = [ int(_) for _ in input().split() ]
    bl, br = 0, 0
    for i in range(m):
        l, r = [ int(_) for _ in input().split() ]
        if l <= x and x <= r:
            bl = min(bl, l)
            br = max(br, r)
    print(br - bl)
