n = int(input())
low = []
high = []
for i in range(n):
    x, apples = map(int, input().split())
    if x < 0:
        low.append((x,apples))
    else:
        high.append((x, apples))
low.sort(reverse = True)
high.sort()

possible = min(len(low), len(high)) + (1 if len(low) != len(high) else 0)
ans = sum([x[1] for x in low[:possible]]) + sum([x[1] for x in high[:possible]])

print(ans)