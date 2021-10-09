/*Intersection Of Sorted Arrays
Problem Description

Find the intersection of two sorted arrays. OR in other words, Given 2 sorted arrays, find all the elements which occur in both the arrays.

Example:

Input:
    A: [1 2 3 3 4 5 6]
    B: [3 3 5]

Output: [3 3 5]

Input:
    A: [1 2 3 3 4 5 6]
    B: [3 5]

Output: [3 5]*/
vector<int> Solution::intersect(const vector<int> &A, const vector<int> &B) {
    int l1=A.size(),l2=B.size(),i=0,j=0;vector<int> C;
    while(i<l1 && j<l2)
    {
        if(A[i]==B[j])
        {
            C.push_back(A[i]);
            i+=1;
            j+=1;
        }
        else if(A[i]>B[j])
            j+=1;
        else
            i+=1;
    }
    return C;
}
