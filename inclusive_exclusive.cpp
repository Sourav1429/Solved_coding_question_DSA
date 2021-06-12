#include<bits/stdc++.h>
int fact(int a)
{
    int i,p=1;
    for(i=1;i<=a;i++)
        p*=i;
    return p;
}
int combination(int a,int b)
{
    return fact(a)/(fact(b)*fact(a-b));
}
int power(int a,int b)
{
    int p=1,i;
    for(i=1;i<=b;i++)
        p*=a;
    return p;
}
int main()
{
    int i,ans=0,flag=1;
    for(i=6;i>=0;i--)
    {
        if(flag)
            ans+=power(i,6)*combination(6,6-i);
        else
           ans-=power(i,6)*combination(6,6-i); 
        flag=flag ^ 1;
    }
    std::cout<<ans;
}