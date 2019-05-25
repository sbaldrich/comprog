from fractions import gcd

n = int(input())
a = sorted(list(map(int, input().split())))
count = {}
for i in a:
    count[i] = count.get(i, 0) + 1

ans = []
i = n-1
while(len(ans) < n):
    top = a.pop()
    while(count[top] < 1):
        top = a.pop()
    count[top] -= 1
    ans.append(top)
    for i in range(len(ans)):
        count[gcd(ans[-1], ans[i])] -= 2
print(' '.join(str(x) for x in ans))
