#include<bits/stdc++.h>
void gen(std::vector<std::vector<int>> &ans,int &N,int idx,std::vector<int> &vect,int col[],int ld[],int rd[])
{
    if(idx==N)
    {
        ans.push_back(vect);
        return;
    }
    int i;
    for(i=0;i<N;i++)
    {
        if(col[i]==1)
            continue;
        else if(rd[idx+N-(i+1)]==1)
            continue;
        else if(ld[idx+i]==1)
            continue;
        vect.push_back(i);
        col[i]=1;
        rd[idx+N-(i+1)]=1;
        ld[idx+i]=1;
        gen(ans,N,idx+1,vect,col,ld,rd);
        vect.pop_back();
        col[i]=0;
        rd[idx+N-(i+1)]=0;
        ld[idx+i]=0;
    }
}
int main()
{
    int n=5;
    std::vector<int> vect;
    std::vector<std::vector<int>> ans;
    int col[n],ld[2*n-1],rd[2*n-1];
    int r=0,i,j;
    gen(ans,n,r,vect,col,ld,rd);
    for(i=0;i<ans.size();i++)
    {
        for(j=0;j<ans[i].size();j++)
        {
            std::cout<<ans[i][j]<<" ";
        }
        std::cout<<"\n";
    }
}