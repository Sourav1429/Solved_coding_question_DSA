/*Sort Array in given Order
Problem Description

Given two array of integers A and B, Sort A in such a way that the relative order among the elements will be the same as those are in B. For the elements not present in B, append them at last in sorted order.

Return the array A after sorting from the above method.

NOTE: Elements of B are unique.



Problem Constraints
1 <= length of the array A <= 100000

1 <= length of the array B <= 100000

-10^9 <= A[i] <= 10^9



Input Format
The first argument given is the integer array A.

The second argument given is the integer array B.



Output Format
Return the array A after sorting as described.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
B = [5, 4, 2]
Input 2:

A = [5, 17, 100, 11]
B = [1, 100]


Example Output
Output 1:

[5, 4, 2, 1, 3]
Output 2:

[100, 5, 11, 17]


Example Explanation
Explanation 1:

 Simply sort as described.
Explanation 2:

 Simply sort as described.*/
//Submit
vector<int> Solution::solve(vector<int> &A, vector<int> &B) {
    //sort(A.begin(),A.end());
    int l1=A.size(),l2=B.size(),i,s;
    std::map<int,int> hash;std::vector<int> c;
    for(i=0;i<l1;i++)
    {
        hash[A[i]]+=1;
    }
    int k=0;
    for(i=0;i<l2;i++)
    {
        if(hash.find(B[i])!=hash.end())
        {
            s=hash[B[i]];
            while(s!=0)
            {
                c.push_back(B[i]);
                s-=1;
                k+=1;
            }
            hash[B[i]]=0;
        }
    }
    for(i=0;i<l1;i++)
    {
        if(hash[A[i]]!=0)
        {
            c.push_back(A[i]);
            hash[A[i]]-=1;
        }
    }
    sort(c.begin()+k,c.end());
    return c;
    
}
