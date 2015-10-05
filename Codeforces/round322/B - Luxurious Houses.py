n = int(input())
height = list(map(int, input().split()))
maxHeight = [0] * n # position i holds the tallest building in positions [i+1,n)
m = 0
for i in range(n-1,0,-1):
    m = max(height[i], m)
    maxHeight[i-1] = m
ans = [max(m - h + 1, 0) for (h,m) in zip(height, maxHeight)]
print(' '.join([str(x) for x in ans]))