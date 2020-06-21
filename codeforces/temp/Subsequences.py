for __ in range(int(input())):
    n = int(input())
    if n <= 2:
        print(('codeforces', 'codeforcess')[n - 1])
    else:
        n += (n & 1)
        k = n // 2
        print('cod', end='')
        print('e'* k, end='')
        print('forc', end='')
        print('e'* k, end='')
        print('s')
