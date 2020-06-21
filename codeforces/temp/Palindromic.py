def dfs(B, T, i, j, l = 0, seen = set()):
    if i >= len(B) or j >= len(B[0]) or (i, j) in seen:
        return
    seen.add((i, j))
    T[l][B[i][j]] += 1
    dfs(B, T, i + 1, j, l + 1, seen)
    dfs(B, T, i, j + 1, l + 1, seen)
    

for __ in range(int(input())):
    n, m = [ int(_) for _ in input().split() ]
    T = [[0, 0] for _ in range(m + n - 1)]
    B = [ [ int(_) for _ in input().split() ] for _ in range(n) ]
    dfs(B, T, 0, 0, 0, set())
    print(T)
    
