/*Find a peak element
Problem Description

Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.

For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the peak element.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
Input 2:

A = [5, 17, 100, 11]


Example Output
Output 1:

 5
Output 2:

 100


Example Explanation
Explanation 1:

 5 is the peak.
Explanation 2:

 100 is the peak.*/
//Their solution
int Solution::solve(vector<int> &A){   
    if(A.size() == 1)
        return A[0];
    if(A[0] >= A[1])
        return A[0];
    if(A[A.size() - 1] >= A[A.size() - 2])
        return A[A.size() - 1];
    int l = 1, r = A.size() - 2;
    while(l <= r){
        int m = (l + r) / 2;
        if(A[m] >= A[m + 1] && A[m] >= A[m - 1])
            return A[m];
        if(A[m] > A[m - 1])
            l = m + 1;
        else
            r = m - 1;
    }
}
//My solution
/*
int max(int a,int b){
    return (a>b)?a:b;
}
int find(vector<int> &A,int l,int u)
{
    if(l==u)
        return INT_MIN;
    if(l==u-1)
        return A[l];
   int mid=(l+u)/2;
    return max(find(A,l,mid),find(A,mid,u));
}
int Solution::solve(vector<int> &A) {
    return find(A,0,A.size());
}
*/
