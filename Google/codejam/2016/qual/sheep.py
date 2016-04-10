T = int( raw_input() )

for t in range(T):
    n = int( raw_input() )
    ans = "INSOMNIA"
    if n:
        ans = n
        s = set(str(n))
        i = 2
        while len(s) < 10 :
            ans = i * n
            i += 1
            s |= set(str(ans))
    print "Case #%d: %s" % (t + 1, ans)
