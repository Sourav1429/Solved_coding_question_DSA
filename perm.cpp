#include<bits/stdc++.h>
using namespace std;
void find_perm(vector<vector<int>> &vect,int a,vector<int> A,vector<int> B,int flag=0)
{
    if(flag==1)
        A.push_back(a);
    int l=B.size(),i,j;
    if(l==0)
    {
        vect.push_back(A);
        return;
    }
    for(i=0;i<l;i++)
    {
        vector<int> C;
        for(j=0;j<l;j++)
            if(j==i)
                continue;
            else
                C.push_back(B[j]);
        find_perm(vect,B[i],A,C,1);
    }
}
int main()
{
    vector<vector<int>> vect;
    vector<int> A{1,2,3,4};vector<int> B;
    int l=A.size(),i,j;
    find_perm(vect,0,B,A);
    for(i=0;i<vect.size();i++)
    {
        for(j=0;j<l;j++)
            cout<<vect[i][j];
        //cout<<A[i];
        cout<<'\n';
    }
}