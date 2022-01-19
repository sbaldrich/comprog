#include<bits/stdc++.h>
#define MAX_CARS 210

using namespace std;

bool dp[MAX_CARS][MAX_CARS * 3000], seen[MAX_CARS][MAX_CARS * 3000], to_port[MAX_CARS][MAX_CARS * 3000];
int car[MAX_CARS], sum[MAX_CARS], length, n;
pair<int,int> ans;

void fill(int , int);
void output(int , int);

int main(){
  ios::sync_with_stdio(false);
  int T; cin >> T;
  bool line = false;

  while(T--){
    if(line) cout << endl;
    line = true;
    cin >> length;
    length *= 100;
    
    memset(dp, 0, sizeof dp);
    memset(seen, 0, sizeof seen);
    memset(to_port, 0, sizeof to_port);
    fill(car, car + MAX_CARS, 0);
    fill(sum, sum + MAX_CARS, 0);
    n = 0;
    int x;
    while(cin >> x && x){
      if(n <= 200){
        ++n;
        car[n] = x;
        sum[n] = sum[n-1] + x;
      }
    }
    dp[0][0] = true;
    ans = make_pair(0, 0);
    fill(0, 0);
    
    cout << ans.first << endl;
    output(ans.first, ans.second);
  }
  return 0;
}
void fill(int c, int port){
  if(c < n && !seen[c][port]){
    seen[c][port] = true;
    if( port + car[c+1] <= length){
      if(c + 1 > ans.first) ans = make_pair(c + 1, port + car[c+1]);
      dp[c+1][port + car[c+1]] = true;
      to_port[c+1][port + car[c+1]] = true;
      fill(c + 1, port + car[c+1]);
    }
    if(sum[c] - port + car[c+1] <= length){
      if(c + 1 > ans.first) ans = make_pair(c + 1, port);
      dp[c+1][port] = true;
      fill(c+1, port);
    }
  }
}
void output(int c, int port){
  if(c == 0) return;
  output(c - 1, port - (to_port[c][port] ? car[c] : 0));    
  cout << (to_port[c][port] ? "port" : "starboard") << endl;
}