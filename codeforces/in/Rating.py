def popc(n):
    return bin(n).count('1')

for __ in range(int(input())):
    n = int(input())
    print(2*n - popc(2*n))
