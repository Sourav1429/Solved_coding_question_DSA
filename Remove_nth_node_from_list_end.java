/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
 //Submit, tested in leetcode
ListNode* Solution::removeNthFromEnd(ListNode* A, int B) {
    ListNode *head=A,*head2=A;int i;
    for(i=0;head!=NULL && i<B;i++)
    {
        head=head->next;
    }
    if(head==NULL && B==1)
    return NULL;
    if(head==NULL)
    {head2=head2->next;
        return head2;}
    while(head->next!=NULL)
    {
        head2=head2->next;
        head=head->next;
    }
    //cout<<head2->val;
    head2->next=head2->next->next;
    return A;
        
}
