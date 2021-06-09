#include<bits/stdc++.h>
void spiral(int r,int c)
{
    int i=0,j=0,k=1,l;
    int **arr=new int*[r];
    for(i=0;i<r;i++)
    {
        arr[i]=new int[c];
    }
    for(i=0;i<r;i++)
    {
        for(j=0;j<c;j++)
        {
            arr[i][j]=0;
        }
    }
    i=0;
while(i<=r/2)
{
    for(j=i;j<c-i;j++)
    {
        arr[i][j]=k++;
    }
    for(l=i+1;l<r-i;l++)
    {
        arr[l][j-1]=k++;
    }
    for(j=j-2;j>=i;j--)
    {
        arr[l-1][j]=k++;
    }
    for(l=l-2;l>i;l--)
    {
        arr[l][i]=k++;
    }
    i+=1;
}
    for(i=0;i<r;i++)
    {
        for(j=0;j<c;j++)
        {
            std::cout<<arr[i][j];
        }
        std::cout<<'\n';
    }
    for(i=0;i<r;i++)
    {
        delete arr[i];
    }
    delete []arr;
}
int main()
{
    int r,c;
    std::cout<<"Enter row and column:";
    std::cin>>r>>c;
    spiral(r,c);
}