n = int(input())
ans = 0
for i in range(n):
    P = [ int(i) for i in input().split() ]
    ans = ans + (sum(P) > 1)
print(ans)
