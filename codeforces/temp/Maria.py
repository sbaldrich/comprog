for tc in range(int(input())):
    n = int(input())
    L = sorted([ int(_) for _ in input().split() ], reverse = True)
    ans = 0
    for i in range(n):
        if L[i] <= n - i:
            ans = n - i
            break
    print(1 + ans)
