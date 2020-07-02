t = int(input())
for tc in range(t):
    n = int(input())
    E, O = [], []
    for i in [ int(_) for _ in input().split() ]:
        O.append(i) if i % 2 else E.append(i)
    if(len(E) % 2):
        ok = False
        for i in E:
            if not ok:
                for j in O:
                    if abs(j - i) == 1:
                        ok = True
                        break
        print('YES' if ok else 'NO')
    else:
        print('YES')
    
