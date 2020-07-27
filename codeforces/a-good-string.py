import os
if 'LOCAL_COMPROG' in os.environ:
    filename = __file__.replace('py', 'in')
    if os.path.exists(filename):
        print('[WARN] swapping stdin for test file')
        import sys
        sys.stdin = open(filename, 'r')


def f(l, r, c):
    if l == r - 1:
        return int(ord(S[l]) != c)
    mid = (r + l) // 2
    moves_left  = (r - l) // 2 - sum([1 for x in S[l:mid] if ord(x) == c])
    moves_right = (r - l) // 2 - sum([1 for x in S[mid:r] if ord(x) == c])
    moves_left  += f(mid, r, c + 1)
    moves_right += f(l, mid, c + 1)
    return min(moves_left, moves_right)

for __ in range(int(input())):
    n = int(input())
    S = input()
    print(f(0, len(S), ord('a')))

