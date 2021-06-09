/*
Problem Description

Given an integer array A containing N distinct integers, you have to find all the leaders in the array A.

An element is leader if it is strictly greater than all the elements to its right side.

NOTE:The rightmost element is always a leader.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 108



Input Format
First and only argument is an integer array A.



Output Format
Return an integer array denoting all the leader elements of the array.

NOTE: Ordering in the output doesn't matter.



Example Input
Input 1:

 A = [16, 17, 4, 3, 5, 2]
Input 2:

 A = [1, 2]


Example Output
Output 1:

 [17, 2, 5]
Output 2:

 [2]


Example Explanation
Explanation 1:

 Element 17 is strictly greater than all the elements on the right side to it.
 Element 2 is strictly greater than all the elements on the right side to it.
 Element 5 is strictly greater than all the elements on the right side to it.
 So we will return this three elements i.e [17, 2, 5], we can also return [2, 5, 17] or [5, 2, 17] or any other ordering.
Explanation 2:

 Only 2 the rightmost element is the leader in the array.
*/
#include<bits/stdc++.h>
std::vector<int> solution(std::vector<int> arr)
{
    int l=arr.size(),i;
    std::vector<int> vect;
    if(l==0)
        return vect;
    vect.push_back(arr[l-1]);
    int max=arr[l-1];
    for(i=l-2;i>=0;i--)
    {
        if(arr[i]>max)
        {
            vect.push_back(arr[i]);
            max=arr[i];
        }
    }
    l=vect.size();
    return vect;
}
int main()
{
    std::vector<int> arr{16, 17, 4, 3, 5, 2},vect;
    vect=solution(arr);
}

//======================Alternative answers============================================//
/*
vector<int> Solution::solve(vector<int> &A) {
    vector<int> v;
int max_so_far=INT_MIN;
for(int i=A.size()-1;i>=0;i--)
{
    if(A[i] > max_so_far) v.push_back(A[i]);
    max_so_far = max(max_so_far,A[i]);
}
return v;
}
*/
//official answer
/*
vector<int> Solution::solve(vector<int> &arr)
{
    vector<int> ans;
    int mx=0;
    for(int i=arr.size()-1; i>=0; i--)
    {
        if(arr[i] > mx)
        {
            mx = arr[i];
            ans.push_back(mx);
        }
    }
    return ans;
}
*/