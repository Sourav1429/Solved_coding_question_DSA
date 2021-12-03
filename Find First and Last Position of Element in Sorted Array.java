/*Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109*/
class Solution {
    public int[] searchRange(int[] A, int target) {
        int n=A.length,i,l,u,last_till_now=-1,first_till_now=-1,mid;
        int arr[]=new int[2];
        l=0;
        u=n-1;
        while(l<=u)
        {
            mid=(l+u)/2;
            if(A[mid]>target)
            {
                u=mid-1;
            }
            else if(A[mid]<target)
            {
                l=mid+1;
            }
            else{
                last_till_now=mid;
                l=mid+1;
            }
        }
        l=0;
        u=n-1;
        while(l<=u)
        {
            mid=(l+u)/2;
            if(A[mid]>target)
            {
                u=mid-1;
            }
            else if(A[mid]<target)
            {
                l=mid+1;
            }
            else{
                first_till_now=mid;
                u=mid-1;
            }
        }
        arr[0]=first_till_now;
        arr[1]=last_till_now;
        return arr;
    }
}
