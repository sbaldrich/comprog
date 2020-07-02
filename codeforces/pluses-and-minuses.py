for __ in range(int(input())):
    S = input()
    cur, lim, res = 0, 0, len(S)
    for i in range(len(S)):
        cur += 1 if S[i] == '+' else -1
        if cur < lim:
            res += i + 1
            lim = cur
    print(res)
