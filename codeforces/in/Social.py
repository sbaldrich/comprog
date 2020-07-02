for __ in range(int(input())):
    n, k = [ int(_) for _ in input().split() ]
    A = [ord(i) - ord('0') for i in input()]
    B = list(reversed(A))
    def f(A):
        P = 0
        
        for i in range(min(k + 1, n)):
            P += A[i]
        
        ans = 0
        for i in range(n):
            if i > k:
                P -= A[i - k - 1]
            if i < n - k:
                P += A[i + k]
            if not P:
                ans += 1
                P = 1
                A[i] = 1
        return ans
    print(min(f(A), f(B)))
