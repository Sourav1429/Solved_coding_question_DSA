/*Unique Paths III
Problem Description

Given a matrix of integers A of size N x M . There are 4 types of squares in it:

1. 1 represents the starting square.  There is exactly one starting square.
2. 2 represents the ending square.  There is exactly one ending square.
3. 0 represents empty squares we can walk over.
4. -1 represents obstacles that we cannot walk over.
Find and return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints
2 <= N * M <= 20
-1 <= A[i] <= 2



Input Format
The first argument given is the integer matrix A.



Output Format
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.



Example Input
Input 1:

A = [   [1, 0, 0, 0]
        [0, 0, 0, 0]
        [0, 0, 2, -1]   ]
Input 2:

A = [   [0, 1]
        [2, 0]    ]


Example Output
Output 1:

2
Output 2:

0


Example Explanation
Explanation 1:

We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Explanation 1:

Answer is evident here.
For further reference check: https://leetcode.com/problems/unique-paths-iii/*/
class Solute{
    int ans;
    public Solute(){
        ans=0;
    }
    public void gen(int A[][],int i,int j,int cnt,int N1,int N2)
    {
        if((i<0)||(i>=N1)||(j<0)||(j>=N2))
            return;
        if(A[i][j]==-1)
            return;
        if(A[i][j]==2)
        {
            if(cnt==0)
                ans+=1;
            return;
        }
        A[i][j]=-1;
        //System.out.println(i+" "+j);
        gen(A,i+1,j,cnt-1,N1,N2);
        A[i][j]=0;
        A[i][j]=-1;
        gen(A,i-1,j,cnt-1,N1,N2);
        A[i][j]=0;
        A[i][j]=-1;
        gen(A,i,j+1,cnt-1,N1,N2);
        A[i][j]=0;
        A[i][j]=-1;
        gen(A,i,j-1,cnt-1,N1,N2);
        A[i][j]=0;
        
    }
}
class Solution {
    public int uniquePathsIII(int[][] A) {
     Solute s=new Solute();
        int i,j,r=A.length,c=A[0].length,sr=-1,sc=-1,cnt=0;
        for(i=0;i<r;i++)
        {
            for(j=0;j<c;j++)
            {
                if(A[i][j]==1)
                {
                    sr=i;
                    sc=j;
                }
                else if(A[i][j]==0)
                {
                    cnt+=1;
                }
            }
        }
        //System.out.print(cnt);
        s.gen(A,sr,sc,cnt+1,r,c);
        return s.ans;   
    }
}
