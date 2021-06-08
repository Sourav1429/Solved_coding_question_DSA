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
#include<bits/stdc++.h>
int **spiral(int n)
{
    int **arr=new int[n],p=1;
    for(i=0;i<n;i++)
    {
        arr[i]=new int[n];
    }
    for(i=0;i<n;i++)
    {
      for(j=0;j<n;j++)
      {
          
      }
    }
}
int main()
{
    int num=4;
    spiral(num);
}