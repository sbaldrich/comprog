n = int(input())
x = 0
for i in range(n):
    x = x + (1 if input()[1] == '+' else -1)
print(x)
