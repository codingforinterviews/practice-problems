#include<iostream>
using namespace std;
int main(){
    int n,t1=0,t2=1,i,nextTerm=0;
    cout<<"Enter the n value: ";
    cin>>n;
    if(n==0 || n==1)
        cout<<n;
    else
        nextTerm=t1+t2;
    for(i=3;i<n;i++){
        t1=t2;
        t2=nextTerm;
        nextTerm=t1+t2;
    }
    cout<<t2;
}
