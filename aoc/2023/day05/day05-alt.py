# This solution makes some assumptions about the input which end up to be true.
# In particular, that there are no cases where a mapping range is completely contained
# in a seed range.

from functools import reduce

with open('input.large.in') as file:
    seeds, *mappings = file.read().split('\n\n')

seeds = list(map(int, seeds.split()[1:]))


def apply(inputs, mapping):
    outputs = []
    for start, length in inputs:
        while length > 0:
            for m in mapping.split('\n')[1:]:
                d, s, l = map(int, m.split())
                if s <= start < s + l:
                    l -= max(start - s, l - length)
                    outputs.append((start - s + d, l))
                    start += l
                    length -= l
                    break
            else:
                outputs.append((start, length))
                break
    return outputs


# part 1
print(min(reduce(apply, mappings, zip(seeds, [1] * len(seeds))))[0])

# part 2
print(min(reduce(apply, mappings, zip(seeds[0::2], seeds[1::2])))[0])