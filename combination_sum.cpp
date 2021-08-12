#include<bits/stdc++.h>
void gen(std::vector<std::vector<int>> &arr,std::vector<int> &v,int B, std::vector<int> &A,int &l,int idx){
    if(v.size()>1)
    {
        int li=v.size();
        if(v[li-1]<v[li-2])
            return;
    }
    if(B==0)
    {
        arr.push_back(v);
        return;
    }
    else if(B<0){
        return;
    }
    int i;
    for(i=0;i<l;i++)
    {
        v.push_back(A[i]);
        gen(arr,v,B-A[i],A,l,idx+1);
        v.pop_back();
    }
}
std::vector<std::vector<int>> solve(std::vector<int> &A,int B){
    std::vector<std::vector<int>> arr;
    std::vector<int> v;
    int l=A.size();
    gen(arr,v,B,A,l,0);
    /*int i,j;
    for(i=0;i<arr.size();i++)
    {
        System.out.println(arr.get(i).size());
        for(j=0;j<arr.get(i).size();j++)
        {
            std::cout<<arr[i][j]<<" ";
        }
        std::cout<<"\n";
    }*/
    return arr;
}
int main() {
    std::vector<int> A{2,3,6,7};
    int B=7,i,j;
    std::vector<std::vector<int>> arr;
    arr=solve(A,B);
    for(i=0;i<arr.size();i++)
    {
        for(j=0;j<arr[i].size();j++)
        {
            std::cout<<arr[i][j];
        }
        std::cout<<"\n";
    }
}
