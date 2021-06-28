/*Longest Common Prefix
Problem Description

Given the array of strings A, you need to find the longest string S which is the prefix of ALL the strings in the array.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

For Example: longest common prefix of "abcdefgh" and "abcefgh" is "abc".



Problem Constraints
0 <= sum of length of all strings <= 1000000



Input Format
The only argument given is an array of strings A.



Output Format
Return the longest common prefix of all strings in A.



Example Input
Input 1:

A = ["abcdefgh", "aefghijk", "abcefgh"]
Input 2:

A = ["abab", "ab", "abcd"];


Example Output
Output 1:

"a"
Output 2:

"ab"


Example Explanation
Explanation 1:

Longest common prefix of all the strings is "a".
Explanation 2:

Longest common prefix of all the strings is "ab".*/
public class Solution {
    public String match(String s1,String s2)
    {
        String str="";int i,j,l1=s1.length(),l2=s2.length();
        for(i=0,j=0;i<l1 && j<l2;i++,j++)
        {
            if(s1.charAt(i)==s2.charAt(j))
                str=str+s1.charAt(i);
            else
                return str;
        }
        return str;
    }
    public String longestCommonPrefix(String[] A) {
        int i,l1=A.length;
        if(l1==0)
            return "";
        if(l1==1)
            return A[0];
        String str=match(A[0],A[1]);
        for(i=2;i<l1;i++)
        {
            str=match(str,A[i]);
        }
        return str;
    }
}
