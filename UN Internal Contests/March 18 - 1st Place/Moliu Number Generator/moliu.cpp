/*
 * moliu.cpp
 *
 *  Created on: Mar 18, 2012
 *      Author: sbaldrich
 */


#include<iostream>

unsigned int f(unsigned int n){
    if(n<4) return n;
    if(n%2){
        if(!((n+1)%4)) return 3+f((n+1)/4);
        else return 3+f((n-1)/4);
    } else return 1+f(n/2);
}

using namespace std;

int main(void){
	unsigned int n;
	//freopen("moliu.in" , "r" , stdin);
	    while(cin>>n){
	       cout << f(n)<<endl;
	    }
	    return 0;
}


