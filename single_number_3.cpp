/*Single Number III
Problem Description

Given an array of numbers A , in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Note: Output array must be sorted.



Problem Constraints
2 <= |A| <= 100000
1 <= A[i] <= 109



Input Format
First argument is an array of interger of size N.



Output Format
Return an array of two integers that appear only once.



Example Input
Input 1:

A = [1, 2, 3, 1, 2, 4]
Input 2:

A = [1, 2]


Example Output
Output 1:

[3, 4]
Output 2:

[1, 2]


Example Explanation
Explanation 1:

 3 and 4 appear only once.
Explanation 2:

 1 and 2 appear only once.*/
//Submit
vector<int> Solution::solve(vector<int> &A) {
    vector<int> vect;int i;
    sort(A.begin(),A.end());
    int l=A.size();
    if(A[0]!=A[1])
        vect.push_back(A[0]);
    for(i=1;i<l-1;i++)
    {
        if(A[i]!=A[i-1] && A[i]!=A[i+1])
            vect.push_back(A[i]);
    }
    if(A[l-1]!=A[l-2])
        vect.push_back(A[l-1]);
    return vect;
}
