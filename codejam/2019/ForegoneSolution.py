T = int(input())
for tc in range(T):
    N = input()
    y = int(N.replace('4','3'))
    k = int(N)
    print(f"Case #{tc + 1}: {y} {k - y}")

