nclude<cstdio>
#include<map>
#include<string>

using namespace std;

int n,scores[1000],m=-50000,i;
char names[1000][33];
map<string,int> ft,st; //first time, second time
map<string,int>:: iterator it;

main(){
       scanf("%d",&n);
       for(i=0;i<n;i++){
           scanf("%s%d",names[i],&scores[i]);
           ft[names[i]]+=scores[i];
           }       
       for(it=ft.begin();it!=ft.end();it++)if(m<it->second)m=it->second;
       
       
       for(i=0;i<n;i++){
           if(ft[names[i]] == m){
               st[names[i]]+=scores[i];
               if(st[names[i]]>=m){
                   printf("%s",names[i]);
                   break;               
                   }                                
               }
           }
        
}
