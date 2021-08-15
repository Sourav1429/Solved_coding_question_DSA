/*Palindrome Partitioning
Problem Description

Given a string A, partition A such that every string of the partition is a palindrome.

Return all possible palindrome partitioning of A.

Ordering the results in the answer : Entry i will come before Entry j if :
len(Entryi[0]) < len(Entryj[0]) OR
(len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR * * *
(len(Entryi[0]) == len(Entryj[0]) AND ... len(Entryi[k] < len(Entryj[k]))


Problem Constraints
1 <= len(A) <= 15



Input Format
First argument is a string A of lowercase characters.



Output Format
Return a list of all possible palindrome partitioning of s.



Example Input
Input 1:

A = "aab"
Input 2:

A = "a"


Example Output
Output 1:

 [
    ["a","a","b"]
    ["aa","b"],
  ]
Output 2:

 [
    ["a"]
  ]


Example Explanation
Explanation 1:

In the given example, ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa").
Explanation 2:

In the given example, only partition possible is "a" .*/
//Submit and see
int palcheck(std::string &A,int l,int u)
{
    if(u-l==1)
        return 1;
    for(int i=l;i<(l+u)/2;i++)
        if(A[i]!=A[l+u-i-1])
            return 0;
    return 1;
}
void gen(std::vector<std::vector<std::string>> &ans,std::string &A,std::vector<std::string> &v,int l,int u)
{
    if(l==u)
    {
        ans.push_back(v);
        return;
    }
    int i,j,a=0;std::string str="";
    for(i=l+1;i<=u;i++)
    {
        a=palcheck(A,l,i);
        if(a==0)
            continue;
        str="";
        for(j=l;j<i;j++)
            str=str+A[j];
        v.push_back(str);
        gen(ans,A,v,i,u);
        v.pop_back();
    }
}
vector<vector<string> > Solution::partition(string A) {
    // Do not write main() function.
    // Do not read input, instead use the arguments to the function.
    // Do not print the output, instead return values as specified
    // Still have a doubt. Checkout www.interviewbit.com/pages/sample_codes/ for more details
    std::vector<std::string> v;std::vector<std::vector<std::string>> ans;
    int l=A.size(),i,j,l1;
    //std::cout<<palcheck(A,0,l);
    gen(ans,A,v,0,l);
    return ans;
}
