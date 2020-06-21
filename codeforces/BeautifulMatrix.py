for i in range(5):
    row = list(input().split())
    if '1' in row:
        c = row.index('1')
        r = i
        ans = abs(2-i) + abs(2-c)
print(ans)
