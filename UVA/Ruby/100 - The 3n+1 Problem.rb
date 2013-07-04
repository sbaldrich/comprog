#This code would exceed the time limit  with big numbers. Must fix.
def f(x)
	return 1 if x <=1
	return 1 + f(x/2) if x%2 == 0
	return 1 + f(3*x + 1)
end 
while line=gets do
	i,j=line.split.map &:to_i
	ans = -1
	[i,j].min.upto([i,j].max) {|x| ans = [ans, f(x)].max}
	puts "#{i} #{j} #{ans}"
end
