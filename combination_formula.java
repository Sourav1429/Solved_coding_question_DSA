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

Given A = "acd".
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
import java.util.Arrays;
class Solution {
    public int find(char ch[],char a,int le)
    {
        int l=0,u=le-1,mid;
        while(l<=u)
        {
            mid=(l+u)/2;
            if(ch[mid]==a)
                return mid;
            else if(ch[mid]>a)
                u=mid-1;
            else
                l=mid+1;
        }
        return 0;
    }
    public long fact(int a){
        long p=1;int m=1000003;
        for(int i=2;i<=a;i++)
            p=(p%m*i%m)%m;
        return p%m;
    }
    public void delet(char []ch,int c,int l){
        for(int i=c;i<l-1;i++)
            ch[i]=ch[i+1];
        ch[l-1]='\0';
    }
    public int solve(String A) {
        int m=1000003,i,l=A.length(),c;char []ch=A.toCharArray();long ans=1l;
        Arrays.sort(ch);
        for(i=0;i<l;i++)
        {
            c=find(ch,A.charAt(i),l-i);
            ans=(ans%m+(fact(l-i-1)%m*c%m)%m)%m;
            //System.out.println(ans);
            delet(ch,c,l-i);
        }
      return (int)(ans%m);  
    }
}

public class combination_formula{
    public static void main(String[] args) {
        String A="sourav";
        Solution s=new Solution();
        System.out.println("Result:"+s.solve(A));
    }
}