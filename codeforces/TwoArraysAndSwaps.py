for i in range(int(input())):
    n, k = [ int(_) for _ in input().split() ]
    A = sorted([ int(_) for _ in input().split() ])
    B = sorted([ int(_) for _ in input().split() ])
    C = sorted(A[:k] + B[-k:])
    A = A[k:]
    B = B[:-k]
    print(sum(A) + (k > 0) * sum(C[-k:]))
