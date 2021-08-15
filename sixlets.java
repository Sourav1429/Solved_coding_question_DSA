/*SIXLETS
Problem Description

Given a array of integers A of size N and an integer B.

Return number of non-empty subsequences of A of size B having sum <= 1000.



Problem Constraints
1 <= N <= 20

1 <= A[i] <= 1000

1 <= B <= N



Input Format
The first argument given is the integer array A.

The second argument given is the integer B.



Output Format
Return number of subsequences of A of size B having sum <= 1000.



Example Input
Input 1:

    A = [1, 2, 8]
    B = 2
Input 2:

    A = [5, 17, 1000, 11]
    B = 4


Example Output
Output 1:

3
Output 2:

0


Example Explanation
Explanation 1:

 {1, 2}, {1, 8}, {2, 8}
Explanation 1:

 No valid subsequence*/
public class Solution {
    public int sixlets(int A[],int B,int i,int sum)
    {
        if(sum<0)return 0;
        if(B==0) return 1;
        if(i>=A.length)
            return 0;
        return sixlets(A,B-1,i+1,sum-A[i])+sixlets(A,B,i+1,sum);
    }
    public int solve(int[] A, int B) {
        return sixlets(A,B,0,1000);
    }
}
