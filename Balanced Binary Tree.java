/*Q4. Balanced Binary Tree
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA and get it resolved.
Get help from TA.
Problem Description
Given a root of binary tree A, determine if it is height-balanced.

A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.



Problem Constraints
1 <= size of tree <= 100000



Input Format
First and only argument is the root of the tree A.



Output Format
Return 0 / 1 ( 0 for false, 1 for true ) for this problem.



Example Input
Input 1:

    1
   / \
  2   3
Input 2:

 
       1
      /
     2
    /
   3


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Explanation 1:

It is a complete binary tree.
Explanation 2:

Because for the root node, left subtree has depth 2 and right subtree has depth 0. 
Difference = 2 > 1. 
*/
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
    public int ans;
    public int check_balanced(TreeNode root)
    {
        if(root==null)
            return 0;
        int d1=0,d2=0;
        if(root.left!=null && root.right!=null)
        {
            d1=check_balanced(root.left);
            d2=check_balanced(root.right);
        }
        else if(root.left!=null)
        {
            d1=check_balanced(root.left);
            d2=0;
        }
        else{
            d1=0;
            d2=check_balanced(root.right);
        }
        if(Math.abs(d1-d2)>1)
            ans=0;
        //System.out.println(root.val+" "+ans+" "+d1+" "+d2);
        return 1+Math.max(d1,d2);
            
    }
    public int isBalanced(TreeNode root) {
        ans=1;
        check_balanced(root);
        return ans;
    }
}
