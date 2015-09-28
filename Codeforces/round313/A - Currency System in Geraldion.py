input()
a = list(map(int, input().split()))
print(-1 if min(a) == 1 else 1)