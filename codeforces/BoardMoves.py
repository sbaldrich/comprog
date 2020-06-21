for __ in range(int(input())):
    n = int(input())
    n = (n - 1) // 2
    print(8 * (n * (n + 1) * (2 * n + 1) // 6))
