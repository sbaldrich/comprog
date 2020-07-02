for __ in range(int(input())):
    a, b = [ int(_) for _ in input().split() ]
    a, b = max(a,b), min(a,b)
    ops = 0
    while a % 8 == 0 and a >> 3 >= b:
        a = a >> 3
        ops += 1
    while a % 4 == 0 and a >> 2 >= b:
        a = a >> 2
        ops += 1
    while a % 2 == 0 and a >> 1 >= b:
        a = a >> 1
        ops += 1
    print(ops if a == b else -1)
