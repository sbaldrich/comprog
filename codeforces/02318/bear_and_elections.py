import heapq

n = map(int, input().split())
votes = list(map(int, input().split()))

limak = votes[0]
votes = [-x for x in votes[1:]]
heapq.heapify(votes)

ans = 0
while limak <= -votes[0]:
    vote = -heapq.heappop(votes)
    vote -= 1
    limak += 1
    ans += 1
    heapq.heappush(votes, -vote)
print(ans)
