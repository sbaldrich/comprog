n = int(input())
ans = 0
cheapest = 1000
for i in range(n):
    needed, price = map(int, input().split())
    cheapest = min(cheapest, price)
    ans += cheapest * needed
print(ans)
