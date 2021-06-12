/*XOR using hashmap*/
#include<bits/stdc++.h>
int solve(std::vector<int> A,int B)
{
    std::map<int,int> hash;int l=A.size(),i,ind2,count=0;
    for(i=0;i<l;i++)
    {
        hash[A[i]^B]++;
    }
    for(i=0;i<l;i++)
    {
        if(hash[A[i]]>0)
        {count+=1;}
    }
    return count/2;
}
int main()
{
    std::vector<int> A{5, 4, 10, 15, 7, 6};
    int B=5;
    std::cout<<solve(A,B);
}