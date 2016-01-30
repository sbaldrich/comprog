n,s = map(int, input().split())

sell = {}
buy = {}

for i in range(n):
    type, price, vol = input().split()
    price = int(price)
    vol = int(vol)
    if type == 'S':
        sell[price] = sell.get(price, 0) + vol
    else:
        buy[price]  = buy.get(price, 0) + vol
for order in sorted(sell.items(), reverse = True )[-s:]:
    print("S", order[0], order[1])
for order in sorted(buy.items(), reverse = True )[:s]:
    print("B", order[0], order[1])
