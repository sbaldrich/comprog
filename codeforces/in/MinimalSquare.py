t = int(input())
for tc in range(t):
    a, b = sorted([int(i) for i in input().split()])
    if b > 2 * a:
        print(b*b)
    else:
        print(4 * a * a)
