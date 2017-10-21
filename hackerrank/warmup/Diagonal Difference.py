n = int(input())
left, right = 0, 0
for i in range(n):
    row = list(map(int, input().split()))
    left += row[i]
    right += row[-i -1]
diff = left - right
print((-1 if diff < 0 else 1) * diff)