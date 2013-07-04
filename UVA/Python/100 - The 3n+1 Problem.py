def f(x):
	if x<=1:
		return 1
	if x%2==0:
		return 1 + f(x/2)
	else:
		return 1 + f(3*x+1)
	
l,r=map(int,raw_input().split())

#Is this the only way to do the continuous reading loop?
while True:
	print f(l)
	try:
		ans = -1
		for x in range(min(l,r), max(l,r)+1):
			ans = max(ans , f(x))
		print "%d %d %d" %(l,r,ans)
		l,r=map(int,raw_input().split())
	except ValueError:
		break

