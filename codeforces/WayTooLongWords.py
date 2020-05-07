n = int(input())
for c in range(n):
    word = input()
    l = len(word)
    print(word if l <= 10 else f'{word[0]}{l - 2}{word[-1]}')
