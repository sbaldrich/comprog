n, c = map(int, input().split())
score = [0] * n
for _ in range(c):
    city = list(map(int, input().split()))
    score[city.index(max(city))] += 1
print(score.index(max(score)) + 1)
