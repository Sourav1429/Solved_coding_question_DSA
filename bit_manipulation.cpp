/*Count Total Set Bits
Problem Description:
Given a positive integer A, the task is to count the total number of set bits in the binary representation of all the numbers from 1 to A.
Return the count modulo 109 + 7.

Problem Constraints
1 <= A <= 109

Input Format
First and only argument is an integer A.

Output Format
Return an integer denoting the ( Total number of set bits in the binary representation of all the numbers from 1 to A )modulo 109 + 7.

Example Input
Input 1:

 A = 3
Input 2:

 A = 1

Example Output
Output 1:

 4
Output 2:

 1

Example Explanation
Explanation 1:

 DECIMAL    BINARY  SET BIT COUNT
    1          01        1
    2          10        1
    3          11        2
 1 + 1 + 2 = 4 
 Answer = 4 % 1000000007 = 4
Explanation 2:

 A = 1
  DECIMAL    BINARY  SET BIT COUNT
    1          01        1
 Answer = 1 % 1000000007 = 1

*/
#include<bits/stdc++.h>
int solve(int A) {
    int i,c,count,a;long sum=0L;
    for(i=1;i<=A;i++)
    {
        count=0;
        a=i;
        while(a!=0)
    {
        c=a&1;
        a=a>>1;
        count+=c;
    }
        sum+=count;
    }
    //cout<<sum;
    sum=sum%1000000007;
    return sum;
}
int main()
{
    int i;
    std::cout<<"Enter a number:";
    std::cin>>i;
    std::cout<<solve(i);
}
//OPTIMISE IT