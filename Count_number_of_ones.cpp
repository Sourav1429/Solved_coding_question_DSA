/*Length of longest consecutive ones
Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.


Input Format

The only argument given is string A.
Output Format

Return the length of the longest consecutive 1’s that can be achieved.
Constraints

1 <= length of string <= 1000000
A contains only characters 0 and 1.
For Example

Input 1:
    A = "111000"
Output 1:
    3

Input 2:
    A = "111011101"
Output 2:
    7*/
#include<bits/stdc++.h>
int solve(string A) {
    int n=A.size(),num_one=0,max,count,i,flag=1;
    for(i=0;i<n;i++)
    {
        if(A[i]=='1')
        {
            num_one+=1;
        }
    }
    int *left=new int[n];
    left[0]=0;
    for(i=1;i<n;i++)
    {
        if(A[i-1]=='1')
            left[i]=left[i-1]+1;
        else
           left[i]=0; 
    }
    int *right=new int[n];
    right[n-1]=0;
    for(i=n-2;i>=0;i--)
    {
        if(A[i+1]=='1')
            right[i]=right[i+1]+1;
        else
           right[i]=0; 
    }
    max=-1;
    for(i=0;i<n;i++)
    {
        if(A[i]=='0')
        {
            count=left[i]+right[i]+1;
            if(max<count)
                max=count;
            flag=0;
        }
        
    }
    if(flag)
        return num_one;
    if(max>num_one)
        return max-1;
    else
        return max;
}
int main()
{
    string A="10101000001";
    std::cout<<solution(A);
}
