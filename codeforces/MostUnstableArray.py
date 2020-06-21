for _t in range(int(input())):
    n, m = [ int(_) for _ in input().split() ]
    print (2 * m if n > 2 else m if n == 2 else 0)
