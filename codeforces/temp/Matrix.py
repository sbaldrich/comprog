for __ in range(int(input())):
    n, m = [ int(_) for _ in input().split() ]
    rs = set()
    cs = set()
    for ri in range(n):
        A = [ int(_) for _ in input().split() ]
        CC = [ i for i, c in enumerate(A) if c == 1 ]
        if len(CC):
            rs.add(ri)
            cs.update(CC)
    ans = min(n, m)
    if n < m:
        ans -= len(rs)
    else:
        ans -= len(cs)
    print(['Vivek', 'Ashish'][ans % 2])
