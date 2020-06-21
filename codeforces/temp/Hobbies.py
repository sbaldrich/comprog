for __ in range(int(input())):
    n = int(input())
    S = set([ int(_) for _ in input().split() ])
    ans = -1
    for k in range(1, 1025):
        T = set([ s ^ k for s in S ])
        if S == T:
            ans = k
            break
    print(ans)
        
