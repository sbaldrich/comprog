red, blue = map(int, input().split())
mixed = min(red, blue)
red -= mixed
blue -= mixed
single = max(red, blue) // 2
print(mixed, single)
