import time
parsed = time.strptime(input(), '%I:%M:%S%p')
print(time.strftime('%H:%M:%S', parsed))
