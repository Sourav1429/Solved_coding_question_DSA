/*Double Character Trouble
Problem Description

You are given a string A.

An operation on the string is defined as follows:

Remove the first occurrence of same consecutive characters. eg for a string "abbcd", the first occurrence of same consecutive characters is "bb".

Therefore the string after this operation will be "acd".

Keep performing this operation on the string until there are no more occurrences of same consecutive characters and return the final string.



Problem Constraints
1 <= |A| <= 100000



Input Format
First and only argument is string A.



Output Format
Return the final string.



Example Input
Input 1:

 A = abccbc
Input 2:

 A = ab


Example Output
Output 1:

 "ac"
Output 2:

 "ab"


Example Explanation
Explanation 1:

Remove the first occurrence of same consecutive characters. eg for a string "abbc", the first occurrence of same consecutive characters is "bb".
Therefore the string after this operation will be "ac".
Explanation 2:

 No removals are to be done.*/
string Solution::solve(string A) {
    vector<char> st;
    int i,l=A.size(),k=1;char c;
    st.push_back(A[0]);
    for(i=1;i<l;i++)
    {
        c=A[i];
        if(st[k-1]==c)
        {
            k-=1;
            st.pop_back();
        }
        else{
            st.push_back(c);
            k+=1;
        }
    }
    std::string s(st.begin(), st.end());
    return s;
}
