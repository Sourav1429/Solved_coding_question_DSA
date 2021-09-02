/*Aggressive cows
Problem Description

Farmer John has built a new long barn, with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall, and an integer B which represent the number of cows.

His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?



Problem Constraints
2 <= N <= 100000
0 <= A[i] <= 109
2 <= B <= N



Input Format
The first argument given is the integer array A.
The second argument given is the integer B.



Output Format
Return the largest minimum distance possible among the cows.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
B = 3
Input 2:

A = [1, 2]
B = 2


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 
John can assign the stalls at location 1,3 and 5 to the 3 cows respectively.
So the minimum distance will be 2.
Explanation 2:

 
The minimum distance will be 1.*/
int find(vector<int> &A,int l,int u)
{
    int i,low=0,high=u-1,mid,till_now=-1;
    /*for(i=0;i<u;i++)
    {
        if(A[i]>=l)
            return A[i];
    }
    return -1;*/
    while(low<=high)
    {
        mid=(low+high)/2;
        if(A[mid]==l)
            return l;
        else if(A[mid]<l)
            low=mid+1;
        else{
            till_now=A[mid];
            high=mid-1;
        }
    }
    return till_now;
}
int Solution::solve(vector<int> &A, int B) {
    sort(A.begin(),A.end());
    int i,l=A.size(),lim,next,flag;
    lim=int(ceil(A[l-1]/(float)(B-1)-A[0]/(float)(B-1)));
    int l_l=0,ans=0,mid;
    while(l_l<=lim)
    {
        mid=(l_l+lim)/2;
        next=A[0];flag=1;
        for(i=1;i<B;i++)
        {
            next+=mid;
            if(next>A[l-1])
            {
                flag=0;break;
            }
            next=find(A,next,l);
            if(next==-1 && i!=B-1)
            {
              flag=0;break;  
            }
        }
        if(flag)
            {
                l_l=mid+1;
                if(mid>ans)
                    ans=mid;
            }
        else
            lim=mid-1;
    }
    return ans;
}
