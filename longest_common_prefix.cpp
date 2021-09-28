/* Get on call with TA  Ask for Help
Bookmark

bookmark-empty
Longest Common Prefix
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

Longest common prefix of all the strings is "ab"*/
//Submit and check in interviewbit
string Solution::longestCommonPrefix(vector<string> &A) {
    string str=A[0],curr,new_str="";
    int i,l=A.size(),j,l1,l2;
    for(i=1;i<l;i++)
    {
        curr=A[i];
        j=0;
        l1=curr.size();l2=str.size();
        while(j<l1 && j<l2)
        {
            if(curr[j]!=str[j])
                break;
            else
            {
                new_str=new_str+curr[j];
            }
            j+=1;
        }
        str=new_str;
        new_str="";
    }
    return str;
}
