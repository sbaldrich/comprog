with open("input.large.in") as file:
    lines = file.read().strip().split('\n')


def next(seq):
    m = []
    for i in range(len(seq)):
        m.append(seq.copy())
        if all([x == 0 for x in seq]):
            break
        seq = [r - l for (l, r) in zip(seq[:-1], seq[1:])]
    m.reverse()
    m[0].extend([0, 0])
    for i in range(1, len(m)):
        m[i].append(m[i][-1] + m[i - 1][-1])
        m[i].insert(0, m[i][0] - m[i-1][0])
    return m[-1][0], m[-1][-1]


seqs = [list(map(int, line.split())) for line in lines]


# part 1
print(sum(next(s)[1] for s in seqs))

# part 2
print(sum(next(s)[0] for s in seqs))

