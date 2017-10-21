x1, v1, x2, v2 = list(map(int, input().split()))
if v1 == v2:
    print('YES' if x2 == x1 else 'NO')
else:
    t = (x2 - x1) / (v1 - v2)
    print('YES' if t >= 0 and t % 1 == 0 else 'NO')
