#!/opt/local/bin/python

import sys

f = open(sys.argv[1], 'r')
lines = [[int(y) for y in line] for line in [ line.strip().split()[1] for line in f.readlines()[1:]]]
for case, line in enumerate(lines):
    people = zip(range(len(line) + 1), line)
    cur = people[0][1]       
    friends = 0
    for shy,n in people[1:]:
        if n:
            if shy > cur:
                friends += shy - cur
                cur += shy - cur
            cur += n
    print 'Case #%d: %d' % (case+1, friends)

                


