input() # Useless first line

n,m = map(int, input().split())
a1 = list(map(int, input().split()))[:n]
a2 = list(map(int, input().split()))[-m:]

print("YES" if a1[-1] < a2[0] else "NO")