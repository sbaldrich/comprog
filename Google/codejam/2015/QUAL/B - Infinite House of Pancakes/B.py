#!/opt/local/bin/python

import sys

f = open(sys.argv[1], 'r')
lines = [[int(y) for y in line] for line in [ line.strip().split() for line in f.readlines()[1:]]]

for case, line in enumerate(lines[1::2]):
    ans = max(line)
    d = 2
    while d < ans:
        print d
        print [ (k-1) // d for k in line]
        ans = min(d + sum([ (k-1) // d for k in line]), ans)
        d += 1
    print "Case #%d: %d" % (case + 1, ans)
