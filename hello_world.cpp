#include <bits/stdc++.h>

using namespace std;

vector<int> merge(vector<int> a, int l,int mid,int u)
{
    cout<<"OK STARTED NOW\n";
    vector<int> b;
    int i=0,k=0,p=0;
    while(i<=u-l)
    {
        if(k==mid-l)
        {
            b.push_back(a[l+p]);
            p++;
        }
        else if(p==u-mid)
        {
            b.push_back(a[mid+k]);
            k++;
        }
        else if(a[k]<a[p])
        {
            b.push_back(a[k]);
            k++;
        }
        else if(a[p]<a[k])
        {
            b.push_back(a[p]);
            p++;
        }
        i+=1;
    }
    return b;
}

void merge_sort(vector<int> arr,int l,int u)
{
    int mid;
    if(l<u)
    {
        return;
    } 
    mid=(l+u)/2;
    merge_sort(arr,l,mid-1);
    merge_sort(arr,mid,u);
    arr=merge(arr,l,mid,u);  
}
int main()
{
    vector<int> arr;
    arr.push_back(2);
    arr.push_back(7);
    arr.push_back(9);
    arr.push_back(3);
    arr.push_back(10);
    int l=arr.size();
    int mid=l/2;
    //arr=merge(arr,0,mid,l-1);
    cout<<l;
    for(int i=0;i<l;i++)
        cout<<arr[i]<<' ';
}