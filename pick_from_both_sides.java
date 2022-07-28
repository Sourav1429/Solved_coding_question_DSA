/*Q3. Pick from both sides!
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA and get it resolved.
Get help from TA.
Problem Description
You are given an integer array A of size N.

You have to pick B elements in total. Some (possibly 0) elements from left end of array A and some (possibly 0) from the right end of array A to get the maximum sum.

Find and return this maximum possible sum.

NOTE: Suppose B = 4, and array A contains 10 elements, then

You can pick the first four elements or can pick the last four elements, or can pick 1 from front and 3 from the back, etc. You need to return the maximum possible sum of elements you can pick.


Problem Constraints
1 <= N <= 105

1 <= B <= N

-103 <= A[i] <= 103



Input Format
First argument is an integer array A.

Second argument is an integer B.



Output Format
Return an integer denoting the maximum possible sum of elements you picked.



Example Input
Input 1:

 A = [5, -2, 3 , 1, 2]
 B = 3
Input 2:

 A = [1, 2]
 B = 1


Example Output
Output 1:

 8
Output 2:

 2


Example Explanation
Explanation 1:

 Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
Explanation 2:

 Pick element 2 from end as this is the maximum we can get*/
//Tested
public class Solution {
    public int solve(int[] arr, int B) {
        int l=arr.length,i,sum=0,max;
         if(B>=l)
            return -1;
        for(i=0;i<B;i++)
        {
            sum+=arr[i];
        }
        max=sum;
        for(i=B-1;i>=0;i--)
        {
            sum-=arr[i];
            sum+=arr[l+i-B];
            if(sum>max)
                max=sum;
        }
        return max;
    }
}
