/*Reorder List
Problem Description

Given a singly linked list A

 A: A0 → A1 → … → An-1 → An 
reorder it to:

 A0 → An → A1 → An-1 → A2 → An-2 → … 
You must do this in-place without altering the nodes' values.



Problem Constraints
1 <= |A| <= 106



Input Format
The first and the only argument of input contains a pointer to the head of the linked list A.



Output Format
Return a pointer to the head of the modified linked list.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5] 
Input 2:

 A = [1, 2, 3, 4] 


Example Output
Output 1:

 [1, 5, 2, 4, 3] 
Output 2:

 [1, 4, 2, 3] 


Example Explanation
Explanation 1:

 The array will be arranged to [A0, An, A1, An-1, A2].
Explanation 2:

 The array will be arranged to [A0, An, A1, An-1, A2].*/
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
 //Submit and accepted in leetcode
ListNode* Solution::reorderList(ListNode* A) {
    ListNode *head=A;ListNode *fast=head,*slow=head,*prev=NULL;
    while(fast!=NULL && fast->next!=NULL)
    {
        prev=slow;
        slow=slow->next;
        fast=fast->next->next;
    }
    
    if(fast!=NULL)
        {
            prev=slow;
            slow=slow->next;
        }
      prev->next=NULL;  
    //Reversing second linkedlist
    ListNode *nxt=NULL,*curr=slow;prev=NULL;
    while(curr!=NULL)
    {
        nxt=curr->next;
        curr->next=prev;
        prev=curr;
        curr=nxt;
    }
    slow=prev;
    while(head!=NULL && slow!=NULL)
    {
        nxt=head->next;
        prev=slow->next;
        head->next=slow;
        slow->next=nxt;
        head=nxt;
        slow=prev;
    }
    return A;
}
