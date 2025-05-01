with open("input.small.in") as file:
    lines = file.read().strip().split('\n')

line = [*'???.###']
springs = [1, 1, 3]


def debug(T, C, G):
    print('     ', ''.join([f"{c: <3}" for c in C]), G) 
    for i, r in enumerate(T):
        print(i, ' ', end ='')
        for j, el in enumerate(r):
            print(f"{el:<3}", end='')
        print()

def dp(cond, groups):
    m, n = len(groups) + 1, len(cond) + 1
    T = [[0] * n for i in range(m)]
    for i in range(1, m):
        for j in range(1, n):
            l = groups[i - 1]
            mask = cond[j-l:j]
            s, e = j-l, j
            can_set = all(c != '.' for c in mask)
            # print(can_set)
            if j - l - 1 > 0:
                can_set &= cond[j - l - 1] != '#'
            # print(can_set)

            # print(f"{i, j, l} checking {mask} = {can_set}")
            if can_set:
                T[i][j] = T[i][j - 1] + T[i-1][j - l - 1] + int(i == 1)

    #print(*T, sep='\n')
    debug(T, cond, groups)
    return max(T[m-1])


for line in lines:
    C, G = line.split()
    G = list(map(int, G.split(',')))
    dp([*C], G)
    print()
    #print([*C], G, f'= {dp([*C], G)}')
