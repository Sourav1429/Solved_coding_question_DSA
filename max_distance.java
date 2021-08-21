/*Max Distance
Problem Description

Given an array A of integers of size N. Find the maximum of value of j - i such that A[i] <= A[j].



Problem Constraints
1 <= N <= 1000000

-109 <= A[i] <= 109



Input Format
First argument is an integer array A of size N.



Output Format
Return an integer denoting the maximum value of j - i.



Example Input
Input 1:

A = [3, 5, 4, 2]


Example Output
Output 1:

2


Example Explanation
Explanation 1:

For A[0] = 3 and A[2] = 4, the ans is (2 - 0) = 2. */
//Submit
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public void sort(int arr[][],int l,int u){
        if(l>=u)
            return;
        int p=u-1;
        int i,j=-1,t,t1;
        for(i=l;i<u;i++)
        {
            if(arr[i][0]<=arr[p][0])
            {
                j+=1;
                t=arr[j][0];
                t1=arr[j][1];
                arr[j][0]=arr[i][0];
                arr[j][1]=arr[i][1];
                arr[i][0]=t;
                arr[i][1]=t1;
            }
        }
        j+=1;
        t=arr[j][0];
        t1=arr[j][1];
        arr[j][0]=arr[p][0];
        arr[j][1]=arr[p][1];
        arr[p][0]=t;
        arr[p][1]=t1;
        sort(arr,l,p);
        sort(arr,p+1,u);
    }
    public int maximumGap(final int[] A) {
        int i,l=A.length,max=Integer.MIN_VALUE,j=-1;
        int arr[][]=new int[l][2];
        for(i=0;i<l;i++)
        {
            arr[i][0]=A[i];
            arr[i][1]=i;
        }
        sort(arr,0,l-1);
        for(i=l-1;i>=0;i--)
        {
            if(arr[i][1]>j)
                j=arr[i][1];
            if(j-i>max)
                max=j-i;
        }
        return max;
    }
}
