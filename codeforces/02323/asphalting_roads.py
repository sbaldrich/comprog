n = int(input())
ans = []
doneH = set()
doneV = set()
for i in range(n**2):
    m, n = map(int, input().split())
    if(m not in doneH and n not in doneV):
        ans.append(i + 1)
        doneH.add(m)
        doneV.add(n)
print(' '.join(str(x) for x in ans))