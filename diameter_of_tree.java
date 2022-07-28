/*Q2. Diameter of binary tree
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA and get it resolved.
Get help from TA.
Problem Description
Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.

The diameter of a tree is the number of edges on the longest path between two nodes in the tree.



Problem Constraints
0 <= N <= 105



Input Format
First and only Argument represents the root of binary tree A.



Output Format
Return an single integer denoting the diameter of the tree.



Example Input
Input 1:

           1
         /   \
        2     3
       / \
      4   5
Input 2:

            1
          /   \
         2     3
        / \     \
       4   5     6


Example Output
Output 1:

 3
Output 2:

 4


Example Explanation
Explanation 1:

 Longest Path in the tree is 4 -> 2 -> 1 -> 3 and the number of edges in this path is 3 so diameter is 3.
Explanation 2:

 Longest Path in the tree is 4 -> 2 -> 1 -> 3 -> 6 and the number of edges in this path is 4 so diameter is 4.*/
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int maxe=Integer.MIN_VALUE;
    public int max(int a,int b)
    {
        return (a>b)?a:b;
    }
    public int height(TreeNode root)
    {
        int d1=0,d2=0,d3=0;
          if(root==null)
            {
                maxe=max(0,maxe);
                return 0;
            }
         else if(root.left==null && root.right==null)
         {
             maxe=max(0,maxe);
             return 0;
         }
         else if(root.right==null)
         {
             d1=height(root.left);
             d2=1;
             d3=0;
         }
         else if(root.left==null)
         {
             d1=0;
             d2=1;
             d3=height(root.right);
         }
         else{
             d1=height(root.left);
             d2=2;
             d3=height(root.right);
         }
         maxe=max(maxe,d1+d2+d3);
         return 1+max(d1,d3);
    }
    public int solve(TreeNode A) {
      
        int d=height(A);
        return maxe;
    }
}
