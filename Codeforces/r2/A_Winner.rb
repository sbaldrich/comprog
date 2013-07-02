log = []
scores = Hash.new(0)
check = Hash.new(0)
gets.to_i.times{
	n,q=gets.split
	scores[n]+=q.to_i
	log << [q,n]
}
m = scores.values.max
log.each{|q,n|
	check[n] += q.to_i
	if check[n] >= m and scores[n] == m then
		puts n
		exit
	end
}
