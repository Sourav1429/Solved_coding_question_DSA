/*Search in a row wise and column wise sorted matrix
Problem Description

Given a matrix of integers A of size N x M and an integer B.
In the given matrix every row and column is sorted in increasing order. Find and return the position of B in the matrix in the given form:
If A[i][j] = B then return (i * 1009 + j)
If B is not present return -1.

Note 1: Rows are numbered from top to bottom and columns are numbered from left to right.
Note 2: If there are multiple B in A then return the smallest value of i*1009 +j such that A[i][j]=B.


Problem Constraints
1 <= N, M <= 1000
-100000 <= A[i] <= 100000
-100000 <= B <= 100000


Input Format
The first argument given is the integer matrix A.
The second argument given is the integer B.


Output Format
Return the position of B and if it is not present in A return -1 instead.


Example Input
A = [ [1, 2, 3]
          [4, 5, 6]
          [7, 8, 9] ]
B = 2


Example Output
1011


Example Explanation
A[1][2]= 2
1*1009 + 2 =1011*/
//Completed and tested just submit
public class Solution {
    public int solve(int[][] A, int B) {
        int N=A.length,M=A[0].length,i,flag=0,j;
        int l,u,mid=-1;
       for(i=0;i<N;i++)
       {
            l=0;u=M-1;
            while(l<=u)
            {
                mid=(l+u)/2;
                if(A[i][mid]==B)
                {
                    //return (i+1)*1009+mid+1;
                    flag=1;
                    break;
                }
                else if(A[i][mid]>B)
                {
                    u=mid-1;
                }
                else if(A[i][mid]<B)
                {
                    l=mid+1;
                }
            }
            if(flag==1)
                break;
        }
        if(flag==1)
        {
            for(j=0;j<=mid;j++)
            {
                if(A[i][j]==B)
                    return (i+1)*1009+j+1; 
            }
        }
        return -1;
    }
}
//Time complexity O(nlogn) and space complexity: O(1)
