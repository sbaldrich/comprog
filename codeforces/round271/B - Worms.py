from itertools import accumulate

def bs(vals, x):
    lo, mid, hi = 0, 0, len(vals) - 1
    while( lo < hi ):
        mid = (lo + hi) // 2
        if(x == vals[mid]):
            return mid
        elif( x > vals[mid] ):
            lo = mid + 1
        else:
            hi = mid
    return lo

n = int(input())
worms = list(map(int, input().split()))
m = int(input())
juicy = list(map(int, input().split()))
sums = list(accumulate(worms))

ans = [str(bs(sums, worm) + 1) for worm in juicy]
print('\n'.join(ans))