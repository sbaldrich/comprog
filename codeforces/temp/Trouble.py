for __ in range(int(input())):
    n = int(input())
    A = [ int(_) for _ in input().split() ]
    T = set([ int(_) for _ in input().split() ])
    yes = len(T) > 1 or A == sorted(A)
    print('Yes' if yes  else 'No')
    
