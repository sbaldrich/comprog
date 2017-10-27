MOD = 1000000007
T = int(input())
SHIRTS = 101

for t in range(T):
    N = int(input())
owns = [[False] * SHIRTS for _ in range(N)]
for i in range(0, N):
    for s in map(int, input().split()):
    owns[i][s] = True
dp = [[0] * (1 << N) for _ in range(SHIRTS)]
dp[0][0] = 1

for s in range(1, SHIRTS):
    for m in range(1 << N):
    dp[s][m] = dp[s - 1][m]
for b in range(N):
    if m & (1 << b) and owns[b][s]:
    dp[s][m] = (dp[s][m] + dp[s-1][m ^ (1 << b)]) % MOD
print(dp[SHIRTS - 1][(1 << N) - 1])