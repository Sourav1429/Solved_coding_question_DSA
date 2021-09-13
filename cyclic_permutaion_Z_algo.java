/*Cyclic Permutations
Problem Description

Given two binary strings A and B, count how many cyclic permutations of B when taken XOR with A give 0.

NOTE: If there is a string, S0, S1, ... Sn-1 , then it's cyclic permutation is of the form Sk, Sk+1, ... Sn-1, S0, S1, ... Sk-1 where k can be any integer from 0 to N-1.



Problem Constraints
1 ≤ length(A) = length(B) ≤ 105



Input Format
First argument is a string A.
Second argument is a string B.



Output Format
Return an integer denoting the required answer.



Example Input
Input 1:

 A = "1001"
 B = "0011"
Input 2:

 A = "111"
 B = "111"


Example Output
Output 1:

 1
Output 2:

 3


Example Explanation
Explanation 1:

 4 cyclic permutations of B exists: "0011", "0110", "1100", "1001".  
 There is only one cyclic permutation of B i.e. "1001" which has 0 xor with A.
Explanation 2:

 All cyclic permutations of B are same as A and give 0 when taken xor with A. So, the ans is 3.*/
//Submit.
public class Solution {
    public int solve(String A, String B) {
        int l1=A.length();
        B=B+B;
        int l2=B.length();
        B=B.substring(0,l2-1);
        A=A+"$"+B;
        //System.out.print(A);
        int l=A.length(),L,R,i,j,c=0;
        int Z[]=new int[l];
        Z[0]=l;
        L=0;R=0;
        for(i=1;i<l;i++)
        {
            if(i>R)
            {
                L=i;R=i;
                while(R<l && A.charAt(R)==A.charAt(R-L))
                {
                    R+=1;
                }
                Z[L]=R-L;
                R-=1;
            }
            else
            {
                j=i-L;
                if(Z[j]<R-i+1)
                {
                    Z[i]=Z[j];
                }
                else{
                    L=i;
                    R++;
                    while(R<l && A.charAt(R-L)==A.charAt(R))
                    {
                        R+=1;
                    }
                    Z[i]=R-L;
                    R-=1;
                }
            }
        }
        for(i=0;i<l;i++)
        {
            if(Z[i]==l1)
                c+=1;
        }
        return c;
    }
}
