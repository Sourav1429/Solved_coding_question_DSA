/*Closest Palindrome
Problem Description

Groot has a profound love for palindrome which is why he keeps fooling around with strings.
A palindrome string is one that reads the same backward as well as forward.

Given a string A of size N consisting of lowercase alphabets, he wants to know if it is possible to make the given string a palindrome by changing exactly one of its character.



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


Example Output
Output 1:

 "YES"
Output 2:

 "NO"


Example Explanation
Explanation 1:

 We can change the character at index 3(1-based) to any other character. The string will be palindromic.
Explanation 2:

 To make the string palindromic we need to change 2 characters. */
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
        if(flag==0 && l%2==1)
            return "YES";
        else if(flag==1)
            return "YES";
        return "NO";
    }
}
