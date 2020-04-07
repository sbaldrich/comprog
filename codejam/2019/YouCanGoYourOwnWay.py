T = int(input())
for tc in range(T):
    N = int(input())
    L = input()
    print('Case #{}: {}'.format(tc + 1, "".join(['E' if c == 'S' else 'S' for c in L])))

