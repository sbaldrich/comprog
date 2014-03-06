x,y = raw_input().split("|"), raw_input()
m,n = len(x[0]),len(x[1])
if m > n:
	d = m-n
	x[1] += y[:d]
	y = y[d:]
elif n < m:	
	d = n-m
	x[0] += y[:d]
	y = y[d:]
x[0] += str(y[0:len(y):2])
x[1] += str(y[1:len(y):2])
if len(x[0]) == len(x[1]):
	print "|".join(x)
else:
	print "Impossible"
