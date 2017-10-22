s, t = list(map(int, input().split()))
a, b = list(map(int, input().split()))
m, n = list(map(int, input().split()))
apples = [x + a for x in list(map(int, input().split()))]
oranges = [x + b for x in list(map(int, input().split()))]

print(sum(s <= i <= t for i in apples))
print(sum(s <= i <= t for i in oranges))
