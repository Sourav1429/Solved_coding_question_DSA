/*Q1. Sorted Array To Balanced BST
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA and get it resolved.
Get help from TA.
Problem Description
Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).

Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.



Problem Constraints
1 <= length of array <= 100000



Input Format
First argument is an integer array A.



Output Format
Return a root node of the Binary Search Tree.



Example Input
Input 1:

 A : [1, 2, 3]
Input 2:

 A : [1, 2, 3, 5, 10]


Example Output
Output 1:

      2
    /   \
   1     3
Output 2:

      3
    /   \
   2     5
  /       \
 1         10


Example Explanation
Explanation 1:

 You need to return the root node of the Binary Tree.*/
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
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public TreeNode root=null;
    public void create(int l,int u,TreeNode prev,int nums[])
    {
        if(l>u)
            return;
        int mid=(l+u)/2;
        TreeNode node=new TreeNode(nums[mid]);
        if(root==null)
        {
            root=node;
            prev=node;
        }
        else if(nums[mid]<prev.val)
        {
            prev.left=node;
            //temp=prev;
            prev=node;
        }
        else{
            prev.right=node;
            //temp=prev;
            prev=node;
        }
        create(l,mid-1,prev,nums);
        create(mid+1,u,prev,nums);
    }
    public TreeNode sortedArrayToBST(final int[] A) {
        TreeNode prev=null;
        int u=A.length;
        int nums[]=A.clone();
        create(0,u-1,prev,nums);
        return root;
    }
}
