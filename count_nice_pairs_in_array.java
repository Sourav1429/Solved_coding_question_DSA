/*You are given an array nums that consists of non-negative integers. Let us define rev(x) as the reverse of the non-negative integer x. For example, rev(123) = 321, and rev(120) = 21. A pair of indices (i, j) is nice if it satisfies all of the following conditions:

0 <= i < j < nums.length
nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
Return the number of nice pairs of indices. Since that number can be too large, return it modulo 109 + 7.

 

Example 1:

Input: nums = [42,11,1,97]
Output: 2
Explanation: The two pairs are:
 - (0,3) : 42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121.
 - (1,2) : 11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12.
Example 2:

Input: nums = [13,10,35,24,76]
Output: 4
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 109*/
class Solution {
    public int rever(int x)
    {
        int rev = 0;
        while(x!=0)
        {
            rev = rev*10 + x%10;
            x=x/10; 
        }
        return rev;
    }
    public int countNicePairs(int[] nums) {
        int N = nums.length,i=0,j,num = 1000000007,rev_i,rev_j;long cnt = 0,val=0;
        j=N-1;
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(i=0;i<N;i++)
        {
            nums[i] = nums[i] - rever(nums[i]);
            if(hash.get(nums[i])==null)
            {
                hash.put(nums[i],1);
            }
            else
            hash.put(nums[i],hash.get(nums[i])+1);
        }
        for(Integer in: hash.keySet())
        {
            val = hash.get(in);
            //System.out.println(val);
            cnt = (cnt + ((val*(val-1))/2))%num;
        }
        return (int)(cnt);
    }
}
