/*Period of a string
Problem Description

Given a string A of length N consisting of lowercase alphabets. Find the period of the string.

Period of the string is the minimum value of k (k >= 1), that satisfies A[i] = A[i % k] for all valid i.



Problem Constraints
1 <= N <= 106



Input Format
First and only argument is a string A of length N.



Output Format
Return an integer, denoting the period of the string.



Example Input
Input 1:

 A = "abababab"
Input 2:

 A = "aaaa"


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 Period of the string will be 2: 
 Since, for all i, A[i] = A[i%2]. 
Explanation 2:

 Period of the string will be 1.*/
public class Solution {
    public int solve(String s) {
        int L=0,R=0,N=s.length(),i,j;
        int Z[]=new int[N];
        Z[0]=N;
        for(i=1;i<N;i++)
        {
            if(i>R)
            {
                L=i;R=i;
                while(R<N)
                {
                    if(s.charAt(R)!=s.charAt(R-L))
                        break;
                    R+=1;
                }
                Z[L]=R-L;
                R-=1;
            }
            else
            {
                j=i-L;
                if(Z[j]<R-i+1){
                    Z[i]=Z[j];
                }
                else{
                    L=i;
                    R++;
                    while(R<N && s.charAt(R-L)==s.charAt(R))
                    {
                        R+=1;
                    }
                    Z[i]=R-L;
                    R-=1;
                }
            }
        }
        for(i=1;i<N;i++)
        {
            if(i+Z[i]==N)
                return i;
        }
        return N;
    }
}
