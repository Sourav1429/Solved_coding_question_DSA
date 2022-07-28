/*Q1. Level Order
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA and get it resolved.
Get help from TA.
Problem Description
Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is root node of the binary tree, A.



Output Format
Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.



Example Input
Input 1:

    3
   / \
  9  20
    /  \
   15   7
Input 2:

   1
  / \
 6   2
    /
   3


Example Output
Output 1:

 [
   [3],
   [9, 20],
   [15, 7]
 ]
Output 2:

 [ 
   [1]
   [6, 2]
   [3]
 ]


Example Explanation
Explanation 1:

 Return the 2D array. Each row denotes the traversal of each level.*/
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
vector<vector<int> > Solution::levelOrder(TreeNode* A) {
    vector<vector<int>> flist;
    vector<int> vect;
    queue<TreeNode*> que;TreeNode* q;
    que.push(A);int i,l=1;
    while(l>0)
    {
        vect.clear();
        for(i=0;i<l;i++)
        {
            q=que.front();
            que.pop();
            vect.push_back(q->val);
            if(q->left!=NULL && q->right!=NULL)
            {
                que.push(q->left);
                que.push(q->right);
            }
            else if(q->left!=NULL)
            {
                que.push(q->left);
            }
            else if(q->right!=NULL)
            {
                que.push(q->right);
            }
        }
        flist.push_back(vect);
        l=que.size();
    }
    return flist;
}
