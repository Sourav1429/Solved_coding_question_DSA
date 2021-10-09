/*Sort stack using another stack
Problem Description

Given a stack of integers A, sort it using another stack.

Return the array of integers after sorting the stack using another stack.



Problem Constraints
1 <= |A| <= 5000

0 <= A[i] <= 1000000000



Input Format
The only argument given is the integer array A.



Output Format
Return the array of integers after sorting the stack using another stack.



Example Input
Input 1:

 A = [5, 4, 3, 2, 1]
Input 2:

 A = [5, 17, 100, 11]


Example Output
Output 1:

 [1, 2, 3, 4, 5]
Output 2:

 [5, 11, 17, 100]


Example Explanation
Explanation 1:

 Just sort the given numbers.
Explanation 2:

 Just sort the given numbers.*/
vector<int> Solution::solve(vector<int> &A) {
    int l=A.size(),l1=0,flag,curr;vector<int> B;
    while(l!=0)
    {
        flag=0;
        curr=A[l-1];
        A.pop_back();
        l-=1;
        if(l1==0)
        {
            B.push_back(curr);
            l1+=1;
            continue;
        }
        while(B[l1-1]>curr)
        {
            A.push_back(B[l1-1]);
            B.pop_back();
            l1-=1;
            l+=1;
            flag=1;
        }
        if(flag==1)
        {
            B.push_back(curr);
            l1+=1;
        }
        else if(B[l1-1]<=curr)
        {
            B.push_back(curr);
            l1+=1;
        }
        
    }
    return B;
}
