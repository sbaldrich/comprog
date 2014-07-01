str = raw_input()
if str == '{}':
    print 0
else:
    print len( set( str[1:-1].replace(' ','').split(',') ) )
