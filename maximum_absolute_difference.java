/*Maximum Absolute Difference
Problem Description

You are given an array of N integers, A1, A2, .... AN.

Return the maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.



Problem Constraints
1 <= N <= 100000

-109 <= A[i] <= 109



Input Format
First argument is an integer array A of size N.



Output Format
Return an integer denoting the maximum value of f(i, j).



Example Input
Input 1:

A = [1, 3, -1]
Input 2:

 
A = [2]


Example Output
Output 1:

5
Output 2:

0


Example Explanation
Explanation 1:

f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

So, we return 5.
Explanation 2:

Only possibility is i = 1 and j = 1. That gives answer = 0.
*/
//Submit and see
public class Solution {
    public int maxArr(int[] A) {
        int l=A.length,i;
        int case1[]=new int[l];
        int case2[]=new int[l];
        for(i=0;i<l;i++)
        {
            case1[i]=A[i]+i;
            case2[i]=A[i]-i;
        }
        int max1,min1,max2,min2,val1=0,val2=0;
        max1=min1=case1[0];max2=min2=case2[0];
        for(i=1;i<l;i++)
        {
            if(case1[i]>max1)
                max1=case1[i];
            if(case1[i]<min1)
                min1=case1[i];
            if(case2[i]>max2)
                max2=case2[i];
            if(case2[i]<min2)
                min2=case2[i];
        }
        val1=max1-min1;val2=max2-min2;
        return (val1>val2)?val1:val2;
    }
}
