n, k = [int(_) for _ in input().split()]
k = k - 1
A = [int(_) for _ in input().split()]
ans = sum(i and i >= A[k] for i in A)
print(ans)
