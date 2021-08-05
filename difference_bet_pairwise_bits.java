/*Different Bits Sum Pairwise
Problem Description

We define f(X, Y) as number of different corresponding bits in binary representation of X and Y.
For example, f(2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, 
so f(2, 7) = 2.

You are given an array of N positive integers, A1, A2 ,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. 
Return the answer modulo 109+7.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 231 - 1



Input Format
First and only argument of input contains a single integer array A.



Output Format
Return a single integer denoting the sum.



Example Input
Input 1:

 A = [1, 3, 5]
Input 2:

 A = [2, 3]


Example Output
Ouptut 1:

 8
Output 2:

 2


Example Explanation
Explanation 1:

 f(1, 1) + f(1, 3) + f(1, 5) + f(3, 1) + f(3, 3) + f(3, 5) + f(5, 1) + f(5, 3) + f(5, 5) 
 = 0 + 1 + 1 + 1 + 0 + 2 + 1 + 2 + 0 = 8
Explanation 2:

 f(2, 2) + f(2, 3) + f(3, 2) + f(3, 3) = 0 + 1 + 1 + 0 = 2*/
class Solution{
    public int fact(int a,int b)
    {
        if(b>a)
            return 0;
        long ans=a;
        ans=ans*(a-1)/2;
        return (int)(ans%1000000007);
    }
    public int solve(int A[])
    {
        int i,l=A.length,a=0,val;long sum=0l;
        int max=A[0];
            for(i=1;i<l;i++)
                if(A[i]>max)
                    max=A[i];
        //System.out.println(max);
        while(max!=0)
        {
            for(i=0;i<l;i++)
            {
                val=A[i]&1;
                a+=val;
                A[i]=A[i]>>1;
            }
            //System.out.println(max+" "+a+" "+(l-a));
            max=max>>1;
            sum=sum%1000000007+(2*(l%1000000007-a%1000000007)%1000000007*a%1000000007)%1000000007;
            a=0;
        }
        return (int)(sum);
    }
}
public class difference_bet_pairwise_bits {
    public static void main(String[] args) {
        int A[]={68,93};
        Solution s=new Solution();
        System.out.println(s.solve(A));
    }
}
