n = int(input())
ans = 1
f = 2
while f * f <= n:
    if(n % f == 0):
        ans *= f
        while(n % f == 0):
            n //= f
    f += 1
if(n > 1):
    ans *= n
print(ans)
