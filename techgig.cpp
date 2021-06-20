//CODE GLADIATORS CODES
//Question 2: Given a range[L,R] both inclusive find the prime numbers such that difference is highest. 3 cases if 2 distinct prime exist print the maximum difference
//If only 1 prime then print 0. If no prime posible print "-1"
#include<bits/stdc++.h>
int sqrt(int N)
{
    int l=0,u=N,mid,till_now=0;
    while(l<=u)
    {
        mid=(l+u)/2;
        if(mid*mid==N)
            return mid;
        else if(mid*mid>N)
            u=mid-1;
        else if(mid*mid<N)
        {
            if(mid*mid>till_now*till_now)
                till_now=mid;
            l=mid+1;
        }
    }
    return till_now;
}
int isprime(int N)
{
    if(N<=1)
        return 0;
    int l=sqrt(N),i;
    for(i=2;i<=l;i++)
        if(N%i==0)
            return 0;
    return 1;
}
int main(int argc, char *a[])
{
    int T,L,R,flag_l,flag_r,diff,i;
    std::cin>>T;
    for(i=1;i<=T;i++)
    {
        std::cin>>L>>R;
        flag_l=0;flag_r=0;
        while(L<=R)
        {
            if(flag_l && flag_r)
                break;
            if(flag_l==0){
            if(isprime(L))
            {
                flag_l=1;
            }
            else
                L+=1;
            }
            if(flag_r==0){
            if(isprime(R))
                flag_r=1;
            else
                R-=1;
            }
        }
        if(flag_l==0 and flag_r==0)
        {
            std::cout<<"-1";
        }
        else{
            diff=R-L;
            std::cout<<diff;
        }
    }
}
