/*Subarray with given sum
Problem Description

Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single element "-1".

First sub-array means the sub-array for which starting index in minimum.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
 B = 5
Input 2:

 A = [5, 10, 20, 100, 105]
 B = 110


Example Output
Output 1:

 [2, 3]
Output 2:

 -1


Example Explanation
Explanation 1:

 [2, 3] sums up to 5.
Explanation 2:

 No subarray sums up to required number.*/
public class Solution {
    public int[] solve(int[] A, int B) {
        int i=0,j=0,l=A.length,flag=0;long sum=A[i];
        while(i<l && j<l)
        {
          if(sum==B)
            {flag=1;break;}
          else if(sum>B)
          {
              sum-=A[i];
              i+=1;
          }
          else{
              if(j==l-1)
                break;
              j+=1;
              sum+=A[j];
          }
        }
        if(flag==0)
        {
            int arr[]=new int[1];
            arr[0]=-1;
            return arr;
        }
        int lo=i,u=j;int arr[]=new int[u-lo+1];
        for(i=lo;i<=u;i++)
            arr[i-lo]=A[i];
        return arr;
    }
}
