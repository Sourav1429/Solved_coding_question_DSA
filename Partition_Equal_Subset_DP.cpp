/*416. Partition Equal Subset Sum
Medium

5902

101

Add to List

Share
Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100*/
class Solution {
public:
    bool subset_sum(vector<int>& nums,int a,int n)
    {
        bool t[n+1][a+1];int i,j;
        for(i=0;i<=n;i++)
        {
            for(j=0;j<=a;j++)
            {
                if(i==0)
                    t[i][j]=false;
                if(j==0)
                    t[i][j]=true;
            }
        }
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=a;j++)
            {
                if(nums[i-1]<=j)
                t[i][j]=t[i-1][j-nums[i-1]]||t[i-1][j];
                else
                    t[i][j]=t[i-1][j];
            }
        }
        return t[n][a];
    }
    bool canPartition(vector<int>& nums) {
        int l=nums.size(),i,ans=0;
        for(i=0;i<l;i++)
        {
            ans=ans+nums[i];
        }
        if(ans%2!=0)
                return false;
        else
        {
            return subset_sum(nums,ans/2,l);
        }
    }
};
