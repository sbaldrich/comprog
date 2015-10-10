n,t = map(int, input().split())
if( n == 1 and t == 10 ):
    print(-1)
else:
    ans = '1' +  '0' * (n - 1) if t == 10 else str(t) * n
    print(ans)