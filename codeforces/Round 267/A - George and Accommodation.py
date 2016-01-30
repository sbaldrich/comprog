n = int( raw_input() )
ans = 0
for i in range( n ):
    x,y = map( int, raw_input().split() )
    if y - x > 2:
        ans+=1
print ans
