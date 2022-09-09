/*409. Longest Palindrome
Easy

3502

203

Add to List

Share
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

 

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.*/
class Solution {
public:
    int longestPalindrome(string s) {
        int *arr=new int[52];
        int l=s.size(),i,max = 0,sum=0;
        for(i=0;i<52;i++)
        {
            arr[i]=0;
        }
        for(i=0;i<l;i++)
        {
            if(s[i]>='A' && s[i]<='Z')
            {
                arr[s[i]-'A']+=1;
            }
            else if(s[i]>='a' && s[i]<='z')
            {
                arr[s[i]-'a'+26]+=1;
            }
        }
        for(i=0;i<52;i++)
        {
            //cout<<arr[i];
            if(arr[i]%2==1)
            {
                if(arr[i]>max)
                    max=arr[i];
                sum =sum +arr[i]-1;
            }
            else
                sum = sum + arr[i];
        }
        if(max>0)
            return sum+1;
        return sum;
    }
};
