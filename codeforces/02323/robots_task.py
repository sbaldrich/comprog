n = int(input())
a = list(map(int, input().split()))
turn = -1
current = 0
while(current < n):
    turn += 1
    for i in range(n):
        if(a[i] >= 0 and a[i] <= current):
            a[i] = -1
            current += 1
    a.reverse()
print(turn)