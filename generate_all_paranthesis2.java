/*
Generate all Parentheses II
Problem Description

Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.



Problem Constraints
1 <= A <= 20



Input Format
First and only argument is integer A.



Output Format
Return a sorted list of all possible paranthesis.



Example Input
Input 1:

A = 3
Input 2:

A = 1


Example Output
Output 1:

[ "((()))", "(()())", "(())()", "()(())", "()()()" ]
Output 2:

[ "()" ]


Example Explanation
Explanation 1:

 All paranthesis are given in the output list.
Explanation 2:

 All paranthesis are given in the output list.*/
public class Solution {
    public void solve(char a,String A,ArrayList<String> vect,int B,int ans,int flag,String C)
    {
        if(flag==1)
        {
            if(a==')')
            {
                ans-=1;
                A=A+Character.toString(a);
            }
            else if(a=='(')
            {
                ans+=1;
                A=A+Character.toString(a);
            }
        }
        if(ans<0)
            return;
        if(B==0)
        {
            if(ans==0)
            {
                vect.add(A);
            }
            return;
        }
        for(int i=0;i<2;i++)
        {
            solve(C.charAt(i),A,vect,B-1,ans,1,C);
        }
    }
    public ArrayList<String> generateParenthesis(int N) {
        int i;char a='0';String A="",C="()";
        ArrayList<String> vect=new ArrayList<String>();
        Solution s=new Solution();
        s.solve(a,A,vect,2*N,0,0,C);
        return vect;
    }
}
