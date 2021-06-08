/*
17. Letter Combinations of a Phone Number
Medium

6265

533

Add to List

Share
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: digits = ""
Output: []

Example 3:
Input: digits = "2"
Output: ["a","b","c"]
 
Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9']*/
#include<bits/stdc++.h>
#include<string.h>
int solution(string a)
{
    vector<string> vect3,vect2;vector<vector<string>> vect;
    int l=a.size();int c,len,len2,len3;
    for(i=0;i<l;i++)
    {
        c=a[i]-48;
        vect.push_back(common[c]);
        /*if(i==0)
           { vect=common[c];
            len=vect.size();}
        else
        {
            vect2=common[c];
            for(k=0;k<len;k++)
            {
            for(j=0;j<len2;j++)
            {
                vect[k]=vect[k]+
            }
            }
        }*/
        
    }
    len=vect.size();len3=vect[0].size();
    vect3=vect[0];
    for(i=1;i<len;i++)
    {
        len2=vect[i].size();
        for(j=0;j<len3;j++)
        {
            for(k=0;k<len2;k++)
            {
                vect2.push_back(vect3[j]+vect[i][k])
            }
        }
        vect3=vect2;
        vect2.clear();
    }
    return vect3;
}
int main()
{
    string a="12";
    solution(a);
}