n,m = map(int, input().split())
print( 1 if n == 1 else m + 1 if n - m > m - 1 else m - 1 )