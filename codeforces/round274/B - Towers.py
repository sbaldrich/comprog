n, k = map(int, input().split())
ops = 0
height = list(map(int, input().split()))
ans = []

while(ops < k):
    pos_lo, lo = min(enumerate(height), key=lambda x: x[1])
    pos_hi, hi = max(enumerate(height), key=lambda x: x[1])
    if(hi == lo):
        break
    height[pos_lo] += 1
    height[pos_hi] -= 1
    ans.append((pos_hi + 1, pos_lo + 1))
    ops += 1
print(max(height) - min(height), ops)
if(len(ans)):
    print('\n'.join(str(x) + ' ' + str(y) for (x, y) in ans))
