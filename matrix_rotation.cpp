/*
Rotate Matrix
Problem Description

You are given a n x n 2D matrix A representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note: If you end up using an additional array, you will only receive partial score.



Problem Constraints
1 <= n <= 1000



Input Format
First argument is a 2D matrix A of integers



Output Format
Return the 2D rotated matrix.



Example Input
Input 1:

 [
    [1, 2],
    [3, 4]
 ]
Input 2:

 [
    [1]
 ]


Example Output
Output 1:

 [
    [3, 1],
    [4, 2]
 ]
Output 2:

 [
    [1]
 ]


Example Explanation
Explanation 1:

 After rotating the matrix by 90 degree:
 1 goes to 2, 2 goes to 4
 4 goes to 3, 3 goes to 1
Explanation 2:

 2D array remains the ssame as there is only element.

*/
#include<bits/stdc++.h>
void solution(std::vector<std::vector<int> > &A){
 int r=A.size(),c=A[0].size(),i,j,t;
    for(i=0;i<r;i++)
    {
        for(j=i;j<c;j++)
        {
            t=A[i][j];
            A[i][j]=A[j][i];
            A[j][i]=t;
        }
    }
    for(i=0;i<r;i++)
    {
        for(j=0;j<c/2;j++)
        {
            t=A[i][j];
            A[i][j]=A[i][c-1-j];
            A[i][c-1-j]=t;
        }
    }
}
int main()
{
    std::vector<std::vector<int>> vect{
        {1,2,3},
        {4,5,6},
        {7,8,9}
    };
    int i,j;
    solution(vect);
    for(i=0;i<3;i++)
    {
        for(j=0;j<3;j++)
        {
            std::cout<<vect[i][j];
        }
    }
}