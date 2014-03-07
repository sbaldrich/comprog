struct Node{
	int id,freq,parent;
	bool operator<(const Node &n) const{
		return this->freq > n.freq;
	}
	Node(){id = freq = parent = 0;}
	friend ostream& operator<<(ostream &o, const Node &n){
		o << "[" << (n.id) << ", " << (n.freq) << "]";
	} 
};


