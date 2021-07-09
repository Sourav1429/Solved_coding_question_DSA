/*A robot is located at the top-left corner of an A x B grid (marked ‘Start’ in the diagram below).

Path Sum: Example 1

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).

How many possible unique paths are there?

Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.

Example :

Input : A = 2, B = 2
Output : 2

2 possible routes : (0, 0) -> (0, 1) -> (1, 1) 
              OR  : (0, 0) -> (1, 0) -> (1, 1)*/
public class Solution {
    public int min(int a,int b)
    {return (a<b)?a:b;}
    public int uniquePaths(int A, int B) {
        int diff_c=B-1;
        int diff_r=A-1;
        int r=min(diff_c,diff_r);
        int n=diff_r+diff_c;
        int limit=n-r;long p=1;
        while(n>limit)
        {
            p*=n;
            n-=1;
        }
        while(r>0)
        {
            p/=r;
            r-=1;
        }
        //System.out.print(p);
        return (int)(p);
       //System.out.print(fact(diff_c+diff_r,maxi)+"====="+fact(maxi,maxi-1));
       //return 0;//(int)(fact(diff_c+diff_r,maxi)/fact(maxi,maxi-1));
    }
}
//Check THIS CODE: 2 liner using recursion
/*
int Solution::uniquePaths(int A, int B) {
if(A == 1 || B ==1) return 1;
return uniquePaths(A-1,B) + uniquePaths(A,B-1);

}
*/
