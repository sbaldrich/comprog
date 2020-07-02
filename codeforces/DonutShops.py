for __ in range(int(input())):
    a, b, c = map(int, input().split())
    if a < c:
        print(1, b if b * a > c else -1)
    else:
        print(-1, b)
