T = int( raw_input() )

for t in range(T):
    cakes = list(raw_input())
    moves = 0
    while True:
        if '-' not in cakes:
            break
        l = cakes.index('-')
        if l > 0:
            cakes[:l] = '-'
            moves += 1
        if '-' not in cakes:
            break
        r = len(cakes) - 1 - cakes[::-1].index('-')
        cakes[:r+1] = ['-' if c == '+' else '+' for c in cakes[r::-1]]
        moves += 1
    print "Case #%d: %d" % (t + 1, moves)
