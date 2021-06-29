//KMP algorithm tested and compiled. Just submit
/*Count Occurrences
Problem Description

Find number of occurrences of bob in the string A consisting of lowercase english alphabets.



Problem Constraints
1 <= |A| <= 1000


Input Format
The first and only argument contains the string A consisting of lowercase english alphabets.


Output Format
Return an integer containing the answer.


Example Input
Input 1:

  "abobc"
Input 2:

  "bobob"


Example Output
Output 1:

  1
Output 2:

  2


Example Explanation
Explanation 1:

  The only occurrence is at second position.
Explanation 2:

  Bob occures at first and third position.*/
public class Solution {
    public int solve(String A) {
        int l=-1,a[]={-1,-1,0},j=-1,N=A.length(),count=0;String str="bob";
        while(l<=N-2)
        {
           if((A.charAt(l+1)==str.charAt(j+1))&&(j==1))
           {
               count+=1;
               j=-1;l-=1;
           }
           else if(A.charAt(l+1)==str.charAt(j+1))
           {
               j+=1;
           }
           else if((A.charAt(l+1)!=str.charAt(j+1))&&(j>-1))
           {
               j=a[j+1];l-=1;
           }
           l+=1;
        }
        return count;
        
    }
}
