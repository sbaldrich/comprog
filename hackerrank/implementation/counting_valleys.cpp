/* name: Counting Valleys
 * source: https://www.hackerrank.com/challenges/counting-valleys
 * judge: Hackerrank
 * tags: ad-hoc, warmup
 */
#include <bits/stdc++.h>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    int n, acc = 0, ans = 0;
    bool valley = false;
    char c;
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> c;
        if(c == 'D') acc--;
        if(c == 'U') acc++;
        if(acc < 0) valley = true;
        if(acc == 0 && valley){
            ans++;
            valley = false;
        }
    }
    cout << ans << endl;
    return 0;
}
