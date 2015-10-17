#include<bits/stdc++.h>

using namespace std;

struct flower{
  flower(int height, int bloom, int wilt) : height(height), bloom(bloom), wilt(wilt) {}
  int height, bloom, wilt;
  bool operator < (const flower& that) const{
    return this -> height < that.height;
  }
};

bool overlap(const flower& first, const flower& second){
  if (first.bloom <= second.bloom)
  return first.wilt >= second.bloom;
  return second.wilt >= first.bloom;
}

class FlowerGarden {
public:
vector <int> getOrdering(vector <int> height, vector <int> bloom, vector <int> wilt) {
  int n = height.size();
  vector<flower> flowers;
  vector<bool> planted = vector<bool>(n, false);
  vector<int> ans;
  int flowers_left = n;
  for(int i = 0; i < n; i++)
      flowers.push_back(flower(height[i], bloom[i], wilt[i]));
  sort(flowers.begin(), flowers.end());
  while(flowers_left--){
    int next = -1;
    for(int i = n - 1; i >= 0; i--){
      if(planted[i])
        continue;
      next = i;
      for(int j = 0; next != -1 && j < n; j++){
        if(i == j || planted[j])
          continue;
        if(overlap(flowers[i], flowers[j]) && flowers[i].height > flowers[j].height)
          next =- 1;
      }
      if(next != -1)
        break;
    }
    ans.push_back(flowers[next].height);
    planted[next] = true;
  }
  return ans;
  }
};
