xx,k = map( int, raw_input().split() )
comp = set( range( 1, xx ) )
for i in xrange( k ):
    l = map( int, raw_input().split() ) 
    comp = comp.difference( l[1:] )
l, h = len( comp ), len( comp )
comp = sorted( list( comp ), reverse=True ) 
while len( comp ) > 1:
    x,y = comp[-2:]
    if y == x - 1:
        l -= 1
        comp.pop()
    comp.pop()
print l,h


