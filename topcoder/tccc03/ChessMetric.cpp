#include <bits/stdc++.h>

using namespace std;

long long dp[55][105][105];

int dr[] = {-1, -2, -2, -1, 1, 2,  2,  1,  0, -1, -1, -1, 0, 1, 1,  1};
int dc[] = {-2, -1,  1,  2, 2, 1, -1, -2, -1, -1,  0,  1, 1, 1, 0, -1};

bool ok( int row, int col, int size ){
	return row < size && row >= 0 && col < size && col >= 0;
}

class ChessMetric {
public:
	long long howMany(int size, vector <int> start, vector <int> end, int moves) {
		for( int k = 0; k <= moves; k++ )
			for( int i = 0; i < size; i++ )
			 	for( int j = 0; j < size; j++ )
					dp[k][i][j] = 0LL;

		for( int i = 0, row, col; i < 16; i++ ){
			row = start[0] + dr[i];
			col = start[1] + dc[i];
			if( ok( row, col, size ) )
				dp[1][row][col] = 1LL;
		}

		for( int k = 2; k <= moves; k++ ){
			for( int i = 0; i < size; i++ ){
				for( int j = 0; j < size; j++ ){
					for( int l = 0, row, col; l < 16; l++ ){
						row = i + dr[l];
						col = j + dc[l];
						if( ok( row, col, size ) )
							dp[k][i][j] += dp[k-1][row][col];
					}
				}
			}
		}
		return dp[moves][end[0]][end[1]];
	}
};
