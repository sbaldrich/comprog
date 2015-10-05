n, k = map(int, input().split())
a = list(map(int, input().split()))
left = [0] * 11
rating = 0
for i in a:
    left[10 - i % 10] += 1
    rating += i // 10
for (i,q) in enumerate(left[1:], start = 1):
    possible = min(q, k // i)
    rating += possible
    k -= possible * i
print(min(rating + k // 10, 10 * n))