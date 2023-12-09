with open("input.large.in") as file:
    lines = file.read().strip().split('\n')

seqs = [list(map(int, line.split())) for line in lines]


def tails(seq):
    while seq:
        yield seq[-1]
        seq = [b - a for a, b in zip(seq, seq[1:])]


# part 1
print(sum(sum(tails(seq)) for seq in seqs))
# part 2
print(sum(sum(tails(seq[::-1])) for seq in seqs))
