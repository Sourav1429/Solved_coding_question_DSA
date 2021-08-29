/*Reverse the String
Problem Description

Given a string A of size N.

Return the string A after reversing the string word by word.

NOTE:

A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.


Problem Constraints
1 <= N <= 3 * 105



Input Format
The only argument given is string A.



Output Format
Return the string A after reversing the string word by word.



Example Input
Input 1:
    A = "the sky is blue"
Input 2:
    A = "this is ib"  


Example Output
Output 1:
    "blue is sky the"
Output 2:
    "ib is this"    


Example Explanation
Explanation 1:
    We reverse the string word by word so the string becomes "the sky is blue".
Explanation 2:
    We reverse the string word by word so the string becomes "this is ib".*/
class Solution{
    public String solve(String str)
    {
        int l=0,n=str.length(),i,flag=1;String s="",f_s="";
        for(i=0;i<n;i++)
        {
            if(str.charAt(i)!=' ')
            {
                s=s+Character.toString(str.charAt(i));
                l+=1;
            }
            else{
                if(l==0)
                    continue;
                else{
                    //System.out.println(s);
                    if(flag==1)
                    {
                        f_s=s+f_s;
                        flag=0;
                        s="";
                        l=0;
                    }
                    else{
                    f_s=s+"_"+f_s;
                    s="";
                    l=0;
                    }
                }
            }
        }
        if(l>0)
            f_s=s+"_"+f_s;
        return f_s;
    }
}
public class reverse_string{
    public static void main(String[] args) {
        String str="     the     sky       is blue     ";
        Solution s=new Solution();
        System.out.print(s.solve(str));
    }
}
