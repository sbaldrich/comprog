# This is a sequence that grows exponentially so the computation is fast. 
# On each iteration it always makes more sense to add the larger number
# to the smaller one.
def f(a,b,n,o):
    if a > n or b > n:
        return o
    return f(max(a,b), a + b, n, o + 1)
for __ in range(int(input())):
    a, b, n = [ int(_) for _ in input().split() ]
    print(f(a,b,n,0))

