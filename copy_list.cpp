/*Copy List
Problem Description

A linked list A is given such that each node contains an additional random pointer which could point to any node in the list or NULL.

Return a deep copy of the list.



Problem Constraints
0 <= |A| <= 106



Input Format
The first argument of input contains a pointer to the head of linked list A.



Output Format
Return a pointer to the head of the required linked list.



Example Input
Given list
   1 -> 2 -> 3
with random pointers going from
  1 -> 3
  2 -> 1
  3 -> 1
  


Example Output
   1 -> 2 -> 3
with random pointers going from
  1 -> 3
  2 -> 1
  3 -> 1
  


Example Explanation
You should return a deep copy of the list. The returned answer should not contain the same node as the original list, but a copy of them. The pointers in the returned list should not link to any node in the original input list.*/
/**
 * Definition for singly-linked list.
 * struct RandomListNode {
 *     int label;
 *     RandomListNode *next, *random;
 *     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
 * };
 */
 //Submit;
RandomListNode* Solution::copyRandomList(RandomListNode* A) {
    RandomListNode *head=A,*copy=NULL,*i=A,*node=NULL,*prev=A;
    while(i!=NULL)
    {
        node=new RandomListNode(i->label);
        if(copy==NULL)
            copy=node;
        i=i->next;
        node->next=prev->next;
        prev->next=node;
        prev=i;
    }
    i=head;
    while(i!=NULL)
    {
        prev=i;
        i=i->next->next;
        if(prev->random!=NULL)
            prev->next->random=prev->random->next;
    }
    i=head;
    while(i!=NULL)
    {
        prev=i->next;
        i=i->next->next;
        if(i!=NULL)
            prev->next=i->next;
        else
            prev->next=NULL;
    }
    return copy;
}
