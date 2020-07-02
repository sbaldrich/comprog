t = int(input())
for tc in range(t):
    n = int(input())
    A = sorted([ int(_) for _ in input().split() ])
    ans = min( abs(a - b) for a, b in zip(A, A[1:] + [10000]) )
    print(ans)
