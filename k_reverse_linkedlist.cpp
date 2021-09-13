/*K reverse linked list
Problem Description

Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return modified linked list.



Problem Constraints
1 <= |A| <= 103

B always divides A



Input Format
The first argument of input contains a pointer to the head of the linked list.

The second arugment of input contains the integer, B.



Output Format
Return a pointer to the head of the modified linked list.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5, 6]
 B = 2
Input 2:

 A = [1, 2, 3, 4, 5, 6]
 B = 3


Example Output
Output 1:

 [2, 1, 4, 3, 6, 5]
Output 2:

 [3, 2, 1, 6, 5, 4]


Example Explanation
Explanation 1:

 For the first example, the list can be reversed in groups of 2.
    [[1, 2], [3, 4], [5, 6]]
 After reversing the K-linked list
    [[2, 1], [4, 3], [6, 5]]
Explanation 2:

 For the second example, the list can be reversed in groups of 3.
    [[1, 2, 3], [4, 5, 6]]
 After reversing the K-linked list
    [[3, 2, 1], [6, 5, 4]]
*/
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
//Submit_verified_in_interviewbit
ListNode* Solution::reverseList(ListNode* A, int B) {
    ListNode *prev=NULL,*curr=A,*nxt=NULL,*init=A,*pinit=NULL,*head=A;int flag=1,i=0;
    while(curr!=NULL)
    {
        nxt=curr->next;
        curr->next=prev;
        i+=1;
        prev=curr;
        if(i==B)
        {
            i=0;
            init->next=nxt;
            if(flag==1)
                {
                    head=curr;
                    flag=0;
                }
            if(pinit!=NULL)
                pinit->next=curr;
            pinit=init;
            prev=init;
            init=nxt;
        }
        curr=nxt;
    }
    return head;
}
