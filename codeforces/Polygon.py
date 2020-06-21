t = int(input())
for tc in range(t):
    n = int(input())
    T = []
    for i in range(n):
        T.append( [True if c == '1' else False for c in input()])
    impossible = False
    for i in range(n - 1, -1, -1):
        if impossible:
            break
        for j in range(n - 1, -1 , -1):
            if impossible:
                break
            if T[i][j]:
                if j == n - 1 or i == n - 1:
                    continue
                else:
                    T[i][j] = True if T[i + 1][j] or T[i][j + 1] else False
                if not T[i][j]:
                    impossible = True
    print('YES' if not impossible else 'NO')
    
