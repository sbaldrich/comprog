/*
ID:santiag4
PROG: milk2
LANG: C++
*/
#include<vector>
#include<iostream>
#include<algorithm>
#include<utility>
#define M 1000001
using namespace std;

int times[M];

main(){
       freopen("milk2.in","r",stdin);
       freopen("milk2.out","w",stdout);
       int N;
       while(cin >> N){
                 //memset(times,-1,sizeof(times));
                 for(int j = 0 ; j<=M ; j++)times[j]=-1;
                 int start,end,maxTime=-1,minTime = M;
                 for(int i=0;i<N;i++){
                         cin>>start>>end;
                         maxTime = max(end,maxTime);
                         minTime = min(start,minTime);
                         for(int j = start ; j<end ; j++)times[j]=1;
                         }
                 int currIdle=0,currMilk=0,maxIdle=0,maxMilk=0;
                 //for(int i  = 0; i<=maxTime ;i++)cout<<times[i]<<endl;
                 //cout << maxTime <<endl;
                 for(int i = minTime; i < maxTime ; i++){
                         if(times[i]==-1){
                                          maxMilk = max(currMilk,maxMilk);
                                          currMilk = 0;
                                          currIdle++;
                                          }
                         else{
                              maxIdle = max(maxIdle,currIdle);
                              currIdle = 0;
                              currMilk++;
                              }
                         }
                 maxIdle = max(maxIdle,currIdle);        
                 maxMilk = max(currMilk,maxMilk);
                 cout<<maxMilk<<" "<<maxIdle<<endl;
                 } 
       }
