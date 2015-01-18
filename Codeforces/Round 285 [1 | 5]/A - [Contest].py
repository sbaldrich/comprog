a, b, c, d = map( int, raw_input().split() )
def f(p,t):
    return max(3 * p / 10, p - p/250 * t )
m, v = f(a,c), f(b,d)
print 'Misha' if m > v else 'Vasya' if v > m else 'Tie' 
