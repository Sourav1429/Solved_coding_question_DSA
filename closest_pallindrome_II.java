/*Groot has increased his level of intelligence and can now comment on giving a string whether a pallindrome can be formed out of it by swapping at-most 1 character. 
He uses the help of an algorithm designed by Rocket to do this. The algorithm returns "YES" if a pallindrome is possible by swapping atmost 1 character. 
In all other cases it says "NO".

Problem Constraints
1 <= N <= 105



Input Format
First and only argument is a string A.



Output Format
Return the string YES if it is possible to make the given string a palindrome by changing exactly 1 character. Else, it should return the string NO.



Example Input
Input 1:

 A = "abbba"
Input 2:

 A = "adaddb"

Input 3:
A="adaddd"

Example Output
Output 1:

 "YES"
Output 2:

 "NO"
 
 Expalanation 1: Here it is already a pallindrome so we do not need to swap any character to get a pallindrome.
 
 Explanation 2: In this case character index pairs (0,5) and (2,3) do not match. Now after making 1 swap between A[2] and A[5], we have the new string as
 adbdda. Now again we see (2,3) is not a perfect match. That means we cannot make a pallindrome out of the string even after 1 swap. So output is "NO".
 
 Explanation 3: In this we again see index pairs (0,5) and (2,3) are not matching. We make 1 swap between A[2] and A[5], we have the new string as adddda. 
 This forms a perfect pallindrome so output is "YES".*/
public class Solution {
    public String solve(String A) {
        int l=A.length(),i,flag=0,fml=-1,fmr=-1,sml=-1,smr=-1;
        for(i=0;i<l/2;i++)
        {
            if((A.charAt(i)!=A.charAt(l-i-1)) && (flag==0))
            {
                fml=i;
                fmr=l-i-1;
                flag=1;
            }
            else if((A.charAt(i)!=A.charAt(l-i-1))&& (flag==1))
            {
                sml=i;
                smr=l-i-1;
                flag=2;
            }
            else if((A.charAt(i)!=A.charAt(l-i-1))&&(flag==2))
                return "NO";
        }
        if(flag==0 && l%2==0)
            return "NO";
        else if(flag==0 && l%2==1)
            return "YES";
        else if(flag==1)
            return "NO";
        else if((A.charAt(fml)==A.charAt(sml))&&(A.charAt(fmr)==A.charAt(smr)))
            return "YES";
        else if((A.charAt(fmr)==A.charAt(sml))&&(A.charAt(fml)==A.charAt(smr)))
            return "YES";
        return "NO";
    }
}

