#include<iostream>
#include<vector>
#include<cmath>

using namespace std;

struct circle{
    int x;
    int y;
    int r;
};

vector<vector<int> > sets;

void createSet(int i){
    vector<int> v;
    v.push_back(i);
    sets.push_back(v);
}

int findSet(int k){
    for(int i=0;i<sets.size();i++){
        for(int j=0;j<sets[i].size();j++){
            if(sets[i][j]==k)
                return i;
        }
    }
}

void mergeSets(int i,int j){
    for(int k=0;k<sets[j].size();k++)
        sets[i].push_back(sets[j][k]);
    sets.erase(sets.begin()+j);
}

int main(){
    //freopen("bomb_the_bridge.in","r",stdin);
    //freopen("bomb_the_bridge.out","w",stdout);
    int n,w,l,b;
    double d;
    cin>>n;
    for(int i=0;i<n;i++){
        cin>>w>>l>>b;
        sets.clear();
        vector<circle> v;
        for(int j=0;j<b;j++){
            circle c;
            cin>>c.x>>c.y>>c.r;
            v.push_back(c);
            createSet(j);
        }
        for(int j=0;j<b;j++){
            for(int k=j+1;k<b;k++){
                d=sqrt(((v[j].x-v[k].x)*(v[j].x-v[k].x))+((v[j].y-v[k].y)*(v[j].y-v[k].y)));
                if(d<=(v[j].r+v[k].r)){
                    int s1,s2;
                    s1=findSet(j);
                    s2=findSet(k);
                    if(s1!=s2)
                        mergeSets(s1,s2);
                }
            }
        }
        vector<int> left,righ;
        bool found=false;
        for(int j=0;j<sets.size();j++){
            bool le=false,r=false;
            for(int k=0;k<sets[j].size();k++){
                if(v[sets[j][k]].x<=v[sets[j][k]].r && v[sets[j][k]].y<=l)
                    le=true;
                if(w-v[sets[j][k]].x<=v[sets[j][k]].r && v[sets[j][k]].y<=l)
                    r=true;
            }
            if(le && r){
                cout<<"Bridge already split"<<endl;
                found=true;
                break;
            }
            else if(le)
                left.push_back(j);
            else if(r)
                righ.push_back(j);
        }
        if(!found){
            double mindist=w,aux;
            for(int j=0;j<left.size();j++){
                for(int k=0;k<sets[left[j]].size();k++){
                    aux=w-(v[sets[left[j]][k]].x+v[sets[left[j]][k]].r);
                    if(aux<mindist)
                        mindist=aux;
                    for(int p=0;p<righ.size();p++){
                        for(int q=0;q<sets[righ[p]].size();q++){
                            d=(sqrt(((v[sets[left[j]][k]].x-v[sets[righ[p]][q]].x)*(v[sets[left[j]][k]].x-v[sets[righ[p]][q]].x))+((v[sets[left[j]][k]].y-v[sets[righ[p]][q]].y)*(v[sets[left[j]][k]].y-v[sets[righ[p]][q]].y))))-(v[sets[left[j]][k]].r+v[sets[righ[p]][q]].r);
                            if(d<mindist)
                                mindist=d;
                        }
                    }
                }
            }
            for(int j=0;j<righ.size();j++){
                for(int k=0;k<sets[righ[j]].size();k++){
                    aux=v[sets[righ[j]][k]].x-v[sets[righ[j]][k]].r;
                    if(aux<mindist)
                        mindist=aux;
                }
            }
            cout<<ceil(mindist/2)<<endl;
        }
    }
    return 0;
} 
