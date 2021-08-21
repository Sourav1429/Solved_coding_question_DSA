/*Spiral Order Matrix II
Problem Description

Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.



Problem Constraints
1 <= A <= 1000



Input Format
First and only argument is integer A


Output Format
Return a 2-D matrix which consists of the elements in spiral order.



Example Input
Input 1:

1
Input 2:

2


Example Output
Output 1:

[ [1] ]
Output 2:

[ [1, 2], [4, 3] ]


Example Explanation
Explanation 1:

 
Only 1 is to be arranged.
Explanation 2:

1 --> 2
      |
      |
4<--- 3*/
//Submit
public class Solution {
    public int[][] generateMatrix(int n) {
        int j,k,i=0,l=1,flag=0;int arr[][]=new int[n][n];
        while(true)
        {
            if(flag==1)
            break;
            for(j=i;j<=n-1-i;j++)
            {
                arr[i][j]=l++;
                if(l==n*n+1)
                    flag=1;
            }
            if(flag==1)
            break;
            for(j=i+1;j<=n-1-i;j++)
            {
                arr[j][n-i-1]=l++;
                if(l==n*n+1)
                    flag=1;
            }
            if(flag==1)
            break;
            for(j=n-2-i;j>=i;j--)
            {
                arr[n-i-1][j]=l++;
                if(l==n*n+1)
                    flag=1;
            }
            if(flag==1)
            break;
            for(j=n-2-i;j>=i+1;j--)
            {
                arr[j][i]=l++;
                if(l==n*n+1)
                    flag=1;
            }
            if(flag==1)
            break;
            i+=1;
        }
        return arr;
    }
}
