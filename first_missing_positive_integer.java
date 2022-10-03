/*41. First Missing Positive
Hard

11841

1458

Add to List

Share
Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses constant extra space.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
link: https://leetcode.com/problems/first-missing-positive/ */
class Solution {
    public void swap(int[] nums,int a,int b)
    {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    public int firstMissingPositive(int[] nums) {
        int i=0,l=nums.length,correctPos;
        while(i<l)
        {
            correctPos = nums[i]-1;
            if(correctPos>=0 && correctPos<l && nums[correctPos]!=nums[i])
                swap(nums,i,correctPos);
            else
                i++;
        }
        for(i=0;i<l;i++)
            if(nums[i]!=i+1)
                return i+1;
        return l+1;
        
    }
}
