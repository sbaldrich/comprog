for __ in range(int(input())):
    a, b = sorted([ int(_) for _ in input().split() ])
    ans = 0
    while a >= 1 and b >= 2:
        ans += 1
        a -= 1
        b -= 2
        a, b = sorted((a, b))
    print(ans)
