/*Problem Description

Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.

Assume that there will only be one solution.



Problem Constraints

-108 <= B <= 108
1 <= N <= 104
-108 <= A[i] <= 108


Input Format

First argument is an integer array A of size N.

Second argument is an integer B denoting the sum you need to get close to.



Output Format

Return a single integer denoting the sum of three integers which is closest to B.



Example Input

Input 1:

A = [-1, 2, 1, -4]
B = 1
Input 2:

 
A = [1, 2, 3]
B = 6


Example Output

Output 1:

2
Output 2:

6


Example Explanation

Explanation 1:

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
Explanation 2:

 Take all elements to get exactly 6.*/
public class Solution {
    public int threeSumClosest(int[] A, int B) {
        int l=A.length,i,j,k,current=0,sum=0,flag=0;
        Arrays.sort(A);
        for(i=0;i<l-1;i++)
        {
            j=i+1;
            k=l-1;
            while(j<k)
            {
                sum=A[i]+A[j]+A[k];
                if(flag==1 && Math.abs(sum-B)<Math.abs(current-B))
                {
                    current=sum;
                }
                else if(flag==0){
                    current = sum;
                    flag=1;
                }
                if(sum<B)
                {
                    j+=1;
                }
                else if(sum>B)
                {
                    k-=1;
                }
                else{
                    return sum;
                }
            }
        }
        return current;
    }
}
