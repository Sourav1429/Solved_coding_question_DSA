/*Merge Two Sorted Arrays
Problem Description

Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.



Problem Constraints
-1010 <= A[i],B[i] <= 1010



Input Format
First Argument is a 1-D array representing A.

Second Argument is also a 1-D array representing B.



Output Format
Return a 1-D vector which you got after merging A and B.



Example Input
Input 1:

A = [4, 7, 9 ]
B = [2 ,11, 19 ]
Input 2:

A = [1]
B = [2]


Example Output
Output 1:

[2, 4, 7, 9, 11, 19]
Output 2:

[1, 2]


Example Explanation
Explanation 1:

Merging A and B produces the output as described above.
Explanation 2:

 Merging A and B produces the output as described above.*/
vector<int> Solution::solve(const vector<int> &A, const vector<int> &B) {
    vector<int> C;
    int l1=A.size(),l2=B.size();int i=0,j=0;
    while((i<l1) && (j<l2))
    {
        if(A[i]<B[j])
        {
            C.push_back(A[i]);
            i+=1;
        }
        else{
            C.push_back(B[j]);
            j+=1;
        }
    }
    while(i<l1)
    {
        C.push_back(A[i]);
        i+=1;
    }
    while(j<l2)
    {
        C.push_back(B[j]);
        j+=1;
    }
    return C;
}
