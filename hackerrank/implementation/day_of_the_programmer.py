def leap(y):
    if y <= 1917:
        return y % 4 == 0
    else:
        return y % 400 == 0 or (y % 4 == 0 and y % 100 != 0)


y = int(input())
print('26.09.1918' if y == 1918 else '{}.09.{}'.format(12 if leap(y) else 13, y))
