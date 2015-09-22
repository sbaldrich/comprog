sticks = map( int, raw_input().split() )
if max( sticks.count( x ) for x in sticks ) < 4: print 'Alien'
elif True in [ sticks.count( x )  in [2,6] for x in sticks ] : print 'Elephant'
else: print 'Bear'
