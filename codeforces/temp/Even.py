for __ in range(int(input())):
    n = int(input())
    A = [ int(_) for _ in input().split() ]
    be, bo = 0, 0
    for i, x in enumerate(A):
        if i % 2 == x % 2:
            continue
        if i % 2:
            bo += 1
        else:
            be += 1
    print (be if be == bo else -1)
