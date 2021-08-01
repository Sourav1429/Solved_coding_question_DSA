/*Delete one
Problem Description

Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.

Find the maximum value of GCD.



Problem Constraints
2 <= N <= 105
1 <= A[i] <= 109



Input Format
First argument is an integer array A.



Output Format
Return an integer denoting the maximum value of GCD.



Example Input
Input 1:

 A = [12, 15, 18]
Input 2:

 A = [5, 15, 30]


Example Output
Output 1:

 6
Output 2:

 15


Example Explanation
Explanation 1:

 
 If you delete 12, gcd will be 3.
 If you delete 15, gcd will be 6.
 If you delete 18, gcd will 3.
 Maximum vallue of gcd is 6.
Explanation 2:

 If you delete 5, gcd will be 15.
 If you delete 15, gcd will be 5.
 If you delete 30, gcd will be 5.*/
 //Submit
public class Solution {
    public int gcd(int a,int b)
    {
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
    public int solve(int[] A) {
        int l=A.length,max=1,i,g;
        int P[]=new int[l];
        int S[]=new int[l];
        for(i=0;i<l;i++)
        {
            if(i==0)
            {
                P[i]=A[i];
                S[l-1]=A[l-1];
            }
            else{
            P[i]=gcd(P[i-1],A[i]);
            S[l-i-1]=gcd(S[l-i],A[l-i-1]);
            }
        }
        for(i=0;i<l;i++)
        {
            if(i==0)
            {
                g=gcd(0,S[i+1]);
            }
            else if(i==l-1)
            {
                g=gcd(P[i-1],0);
            }
            else{
            g=gcd(P[i-1],S[i+1]);
            }
            if(g>max)
                max=g;
        }
        return max;
    }
}
