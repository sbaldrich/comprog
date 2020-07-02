for __ in range(int(input())):
    S = input()
    freq = {}
    for c in S:
        freq[c] = freq.get(c, 0) + 1
    possible_moves = min(freq.get('0', 0), freq.get('1', 0))
    print(['NET', 'DA'][possible_moves & 1])
