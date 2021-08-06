/*
Mod Sum
Problem Description

Given an array of integers A, calculate the sum of A [ i ] % A [ j ] for all possible i, j pairs. Return sum % (109 + 7) as an output.



Problem Constraints
1 <= length of the array A <= 105

1 <= A[i] <= 103



Input Format
The only argument given is the integer array A.



Output Format
Return a single integer denoting sum % (109 + 7).



Example Input
Input 1:

 A = [1, 2, 3]
Input 2:

 A = [17, 100, 11]


Example Output
Output 1:

 5
Output 2:

 61


Example Explanation
Explanation 1:

 (1 % 1) + (1 % 2) + (1 % 3) + (2 % 1) + (2 % 2) + (2 % 3) + (3 % 1) + (3 % 2) + (3 % 3) = 5
*/
//Submit
public class Solution {
    public int solve(int[] A) {
        int i,j,l=A.length,m=1000000007,val;int arr[]=new int[1001];long ans=0l,t;
        for(i=0;i<l;i++)
            arr[A[i]]+=1;
        for(i=1;i<=1000;i++)
        {
            for(j=1;j<=1000;j++)
            {
                if(arr[i]==0 || arr[j]==0)
                    continue;
                val=j%i;
                t=arr[i]*arr[j]*val;
                ans=(ans%m+(t)%m)%m;
            }
        }
        return (int)(ans);
    }
}
