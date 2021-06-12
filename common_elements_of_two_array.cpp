#include<bits/stdc++.h>
std::vector<int> solve(std::vector<int> A,std::vector<int> B){
    std::map<int,int> hash;int i,m=A.size(),n=B.size();std::vector<int> vect;
    for(i=0;i<m;i++)
    {
        hash[A[i]]++;
    }
    for(i=0;i<n;i++)
    {
        if(hash[B[i]]>0)
        {
            //std::cout<<B[i]<<' ';
            vect.push_back(B[i]);
            hash[B[i]]--;
        }
    }
}
int main()
{
    std::vector<int> A{2,2,2};
    std::vector<int> B{1,2,2};
    std::vector<int> vect=solve(A,B);
    for(int i=0;i<vect.size();i++)
    {
        std::cout<<vect[i]<<' ';
    }
}