#include<bits/stdc++.h>

using namespace std;

string names[] = {"Stack", "Queue", "Front"};

void push( int i ){
	cout << "push" << names[i];
}

void pop( int i ){
	cout << " pop" << names[i];
}


int main(){
	ios::sync_with_stdio(0);
	cin.tie( 0 );
	int n; cin >> n;
	vector<int> nums, top( 3, -1 );
	vector<bool> used( 3, false );
	int line = 0, x = -1;
	for( int i = 0; i < n; i++ ){ 
		cin >> x;
		if( x ){
			for( int i = 0; i < 3; i++ ){
				if( x > top[i] ){
					for( int j = 2; j > i; j-- )
						top[j] = top[j - 1];
					top[i] = x;
					break;
				}
			}
			nums.push_back( x );	
		}
		else{
			if( nums.size() > 2 ){
				int ind = 0;
				for( int i = 0; i < nums.size(); i++ ){ 
					bool t = 0;
					for( int ii = 0; ii < 3; ii++ ){
						if( ( nums[i] == top[ii] ) && !used[ii] ){
							t = used[ii] = true;
							break;
						}
					}
					if( t ){
						push( ind++ );
					}
					else
						cout << "pushBack";
					cout << endl;
				}
				cout << 3;
				for( int i = 0; i < ind; i++ )
					pop( i );
				cout << endl;
			}
			else{
				for( int i = 0; i < nums.size(); i++ ){
					push( i );
					cout << endl;
				}
				cout << nums.size();
				for( int i = 0; i < nums.size(); i++ )
					pop( i );
				cout << endl;
			}
			top = vector<int>( 3, -1);
			used = vector<bool>( 3, false );
			nums.clear();
		}
	}
	if( !nums.empty() ){
		for( int i = 0 ; i < nums.size(); i++ ){
			push( 0 );
			cout << endl;
		}
	}
	return 0;
}
