import math

n, m, a, b = map( int, raw_input().split() )
no_special = a * n
special = int( b * math.ceil( n / float(m) ) )
both = b * ( n / m ) + ( n % m ) * a
print min( no_special, special, both )
