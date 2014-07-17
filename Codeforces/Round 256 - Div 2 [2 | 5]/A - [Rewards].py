import math

cups = map( int, raw_input().split() )
medals = map( int, raw_input().split() ) 
shelves = int( raw_input() )

shelves -= math.ceil( sum( cups ) / 5.0 )
shelves -= math.ceil( sum( medals ) / 10.0 )

if shelves >= 0:
    print "YES"
else:
    print "NO"
