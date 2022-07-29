/*Q4. Kth Smallest Element In BST
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA and get it resolved.
Get help from TA.
Problem Description
Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format
First and only argument is head of the binary tree A.



Output Format
Return an integer, representing the Bth element.



Example Input
Input 1:

 
            2
          /   \
         1    3
B = 2
Input 2:

 
            3
           /
          2
         /
        1
B = 1



Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

2nd element is 2.
Explanation 2:

1st element is 1.*/
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 void search_kth(TreeNode *root,int &ans,int &flag,int &k)
    {
        if(root==NULL)
            return;
        search_kth(root->left,ans,flag,k);
        k-=1;
        if(flag==0)
        {
            if(k==0)
            {
                ans=root->val;
                flag=1;
            }
        }
        else{
            return;
        }
        search_kth(root->right,ans,flag,k);
        
    }
int Solution::kthsmallest(TreeNode* root, int k) {
    int ans=-1,flag=0;
        search_kth(root,ans,flag,k);
        return ans;
}
//SUBMIT
