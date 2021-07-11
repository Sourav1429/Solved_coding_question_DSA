/*Sorted Permutation Rank
Problem Description

Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
Assume that no characters are repeated.

Note: The answer might not fit in an integer, so return your answer % 1000003



Problem Constraints
1 <= |A| <= 1000



Input Format
First argument is a string A.



Output Format
Return an integer denoting the rank of the given string.



Example Input
Input 1:

A = "acb"
Input 2:

A = "a"


Example Output
Output 1:

2
Output 2:

1


Example Explanation
Explanation 1:

Given A = "acb".
The order permutations with letters 'a', 'c', and 'b' : 
abc
acb
bac
bca
cab
cba
So, the rank of A is 2.
Explanation 2:

Given A = "a".
Rank is clearly 1.*/
import java.lang.String;
import java.util.Arrays;
class Solution{
    public int find(char tempArray[],char ch,int l){
        int u=tempArray.length-1,mid=-1;
        while(l<=u){
            mid=(l+u)/2;
            if(tempArray[mid]==ch)
            {
                return mid;
            }
            else if(tempArray[mid]>ch)
            {
                u=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return mid;
    }
    public int fact(int n)
    {
        int p=n;
        while(n-->1)
        {
            p=(p*n)%1000003;
        }
        return p;
    }
    public void change(char tempArray[],int l,int pos){
        int i;char ch=tempArray[pos];
        for(i=pos;i>l;i--)
        {
            tempArray[i]=tempArray[i-1];
        }
        tempArray[l]=ch;
    }
    public int solve(String A) {
        char tempArray[] = A.toCharArray(),t; 
        Arrays.sort(tempArray);int i,pos,l=A.length(),sum=1;
        for(i=0;i<l;i++)
        {
            pos=find(tempArray,A.charAt(i),i);
            sum=(sum%1000003+((pos-i)%1000003)*((fact(l-1-i)%1000003))%1000003)%1000003;
            change(tempArray,i,pos);
        }
        return sum;
    }
}
public class sorted_permutation_rank
{
   public static void main(String[] args) {
       String A="DTNGJPURFHYEW";
       Solution s=new Solution();
       System.out.print(s.solve(A));
   } 
}
/*Steps
1) Sort the string-------->A.sort();
2) Find a character position (n-i-1)!

*/