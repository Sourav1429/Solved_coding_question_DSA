/* Remove Loop from Linked List
Problem Description

Given a linked list which contains some loop.

You need to find the node, which creates a loop, and break it by making the node point to NULL.



Problem Constraints
1 <= number of nodes <= 1000



Input Format
Only argument is the head of the linked list.



Output Format
return the head of the updated linked list.



Example Input
Input 1:

 
1 -> 2
^    |
| - - 
Input 2:

3 -> 2 -> 4 -> 5 -> 6
          ^         |
          |         |    
          - - - - - -


Example Output
Output 1:

 1 -> 2 -> NULL
Output 2:

 3 -> 2 -> 4 -> 5 -> 6 -> NULL


Example Explanation
Explanation 1:

 Chain of 1->2 is broken.
Explanation 2:

 Chain of 4->6 is broken.
*/
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
ListNode* Solution::solve(ListNode* A) {
    //finding location of common node
    ListNode *ptr1=A,*ptr2=A,*ptr3=A,*prev=NULL;
    int flag=0,k=0;
    while(1)
    {
        if((ptr1==ptr2)&&(flag==1))
        {
            break;
        }
        ptr1=ptr1->next;
        ptr2=ptr2->next->next;
        flag=1;
    }
    //cout<<"ok";
    flag=0;
    while(1)
    {
        if((ptr1==ptr2)&&(flag==1))
        {
            break;
        }
        ptr1=ptr1->next;
        flag=1;
        k+=1;
    }
    //cout<<"ok";
    while(k!=0)
    {
        ptr3=ptr3->next;
        k-=1;
    }
    ptr1=A;
    //cout<<"ok";
    while(ptr1!=ptr3)
    {
        prev=ptr3;
        ptr1=ptr1->next;
        ptr3=ptr3->next;
    }
    //cout<<"ok";
    prev->next=NULL;
    return A;
}
