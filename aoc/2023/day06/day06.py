import math

with open("input.large.in") as file:
    lines = file.read().strip().split('\n')

tds = list(zip(*(map(int, line.split()[1:]) for line in lines)))

def count_em(time, distance):
    ways = 0
    for i in range(1, time):
        ways += bool((i * (time - i)) > distance)
    return ways

# part 1
print(math.prod(count_em(t, d) for t,d in tds))

# part 2
print(count_em(* map(int, (line.replace(' ', '').split(':')[1] for line in lines))))
