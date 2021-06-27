/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
0 <= n <= 3 * 104
0 <= height[i] <= 105*/
class Solution{
    public int max(int a,int b)
    {
        return (a>b)?a:b;
    }
    public int min(int a,int b){
        return (a>b)?b:a;
    }
    public int solve(int []arr){
        int N=arr.length,i,trap=0,val;
        int left[]=new int[N];
        int right[]=new int[N];
        left[0]=arr[0];
        for(i=1;i<N;i++)
        {
            left[i]=max(left[i-1],arr[i]);
        }
        right[N-1]=arr[N-1];
        for(i=N-2;i>=0;i--)
        {
            right[i]=max(right[i+1],arr[i]);
        }
        for(i=0;i<N;i++)
        {
            System.out.println(left[i]+" "+arr[i]+" "+right[i]);
            val=min(left[i],right[i]);
            trap+=(val-arr[i]);
        }
    return trap;
    }
}
public class rain_water_trapping {
    public static void main(String[] args) {
        int arr[]={4,2,0,3,2,5};
        Solution s=new Solution();
        System.out.print(s.solve(arr));
    }
    
}

//2 pointer approach in c++
/*
int trap(vector<int>& height)
{
    int left = 0, right = height.size() - 1;
    int ans = 0;
    int left_max = 0, right_max = 0;
    while (left < right) {
        if (height[left] < height[right]) {
            height[left] >= left_max ? (left_max = height[left]) : ans += (left_max - height[left]);
            ++left;
        }
        else {
            height[right] >= right_max ? (right_max = height[right]) : ans += (right_max - height[right]);
            --right;
        }
    }
    return ans;
}
More optimal TC: O(n) and SC: O(1).*/
